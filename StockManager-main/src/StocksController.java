import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StocksController implements Initializable {

    @FXML
    private TableColumn<Stocks2, String> stockColumn;

    @FXML
    private TableColumn<Stocks2, Integer> initialpriceColumn;

    @FXML
    private TableColumn<Stocks2, Integer> tradingpriceColumn;

    @FXML
    private TableColumn<Stocks2, Integer> avaliblestocksColumn;


    @FXML
    private TableColumn<Stocks2, Void> deleteColumn;

    @FXML
    private TableView<Stocks2> stockTable;

    @FXML
    private Button addButton;

    private final ObservableList<Stocks2> stockList = FXCollections.observableArrayList();
    private final String csvFilePath = "C://Users//Ziiad//Downloads//testfile.csv";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Linking table columns with Stocks properties
        stockColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStockName()));
        initialpriceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInitialPrice()).asObject());
        tradingpriceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getTradingPrice()).asObject());
        avaliblestocksColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAvaliblestocks()).asObject());

        // Create delete button column
        deleteColumn.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete");

            {
                deleteButton.setOnAction(event -> {
                    Stocks2 stock = getTableView().getItems().get(getIndex());
                    stockList.remove(stock);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        // Populate table with data
        readData();
        stockTable.setItems(stockList);

        // Add button event handler
        addButton.setOnAction(event -> addEntry());
    }

    private void readData() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 4) { // Ensure all columns are present
                    String stockName = row[0];
                    int initialPrice = Integer.parseInt(row[1]);
                    int tradingPrice = Integer.parseInt(row[2]);
                    int availableStocks = Integer.parseInt(row[3]); // Parse available stocks
                    Stocks2 stock = new Stocks2(stockName, initialPrice, tradingPrice, availableStocks);
                    stock.setAvailableStocks(availableStocks); // Set available stocks
                    stockList.add(stock);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            showErrorDialog("Error", "Failed to read data from CSV file.");
        }
    }



    private void addEntry() {
        // Create a dialog to prompt the user for new stock details
        Dialog<Stocks2> dialog = new Dialog<>();
        dialog.setTitle("Add New Stock");
        dialog.setHeaderText(null);

        // Set the button types
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        // Create text fields and labels for stock details
        TextField stockNameField = new TextField();
        stockNameField.setPromptText("Stock Name");
        TextField initialPriceField = new TextField();
        initialPriceField.setPromptText("Initial Price");
        TextField tradingPriceField = new TextField();
        tradingPriceField.setPromptText("Trading Price");
        TextField availableStocksField = new TextField();
        availableStocksField.setPromptText("Available Stocks");

        // Add text fields to a VBox
        VBox vbox = new VBox(10, new Label("Enter Stock Details:"),
                stockNameField, initialPriceField, tradingPriceField, availableStocksField);

        dialog.getDialogPane().setContent(new ScrollPane(vbox));

        // Request focus on the stock name field by default
        dialog.setOnShown(event -> stockNameField.requestFocus());

        // Convert the result to a stock when the addButton is clicked
        dialog.setResultConverter(buttonType -> {
            if (buttonType == addButtonType) {
                try {
                    String stockName = stockNameField.getText();
                    int initialPrice = Integer.parseInt(initialPriceField.getText());
                    int tradingPrice = Integer.parseInt(tradingPriceField.getText());
                    int availableStocks = Integer.parseInt(availableStocksField.getText());
                    return new Stocks2(stockName, initialPrice, tradingPrice, availableStocks);
                } catch (NumberFormatException e) {
                    showErrorDialog("Invalid Input", "Please enter valid numbers for initial price, trading price, and available stocks.");
                }
            }
            return null;
        });

        // Show the dialog and handle the result
        Optional<Stocks2> result = dialog.showAndWait();
        result.ifPresent(stock -> {
            stockList.add(stock);
            writeEntryToCSV(stock);
        });
    }

    private void writeEntryToCSV(Stocks2 stock) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath, true))) {
            writer.println(stock.getStockName() + "," + stock.getInitialPrice() + "," + stock.getTradingPrice() + "," + stock.getAvaliblestocks());
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("Error", "Failed to write data to CSV file.");
        }
    }


    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
