

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.opencsv.CSVWriter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.opencsv.CSVWriter;
import java.io.FileWriter;


import java.io.IOException;

public class StockCsvReader implements Initializable {
    private Map<Stocks, TextField> quantityFieldsMap = new HashMap<>();

    @FXML
    private TableView<Stocks> tableView;
    @FXML
    private TableColumn<Stocks, Button> BuyColumn;
    @FXML
    private TableColumn<Stocks, TextField> QuantityCol;
    @FXML
    private TableColumn<Stocks, Integer> PriceColumn;
    @FXML
    private TableColumn<Stocks, Integer> initialPriceColumn;
    @FXML
    private TableColumn<Stocks, String> StockColumn;
    @FXML
    private TableColumn<Stocks, Integer> Stocksnumber;

    ArrayList<Stocks> stocksList = new ArrayList<>();

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//Ziiad//Downloads//testfile.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 4) {
                    String stockName = row[0];
                    int initialPrice = Integer.parseInt(row[1]);
                    int stocksNumber = Integer.parseInt(row[2]);
                    int price = Integer.parseInt(row[3]);
                    Button buyButton = new Button("Buy");
                    TextField quantityField = new TextField();
                    Stocks stock = new Stocks(stockName, initialPrice, stocksNumber, price, buyButton, quantityField);
                    stocksList.add(stock);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tableView.getItems().addAll(stocksList);
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        PriceColumn.setPrefWidth(100);
        Stocksnumber.setPrefWidth(100);
        StockColumn.setPrefWidth(200);
        initialPriceColumn.setPrefWidth(100);

        StockColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStockName()));
        initialPriceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInitialPrice()).asObject());
        Stocksnumber.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStockNumber()).asObject());
        PriceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice()).asObject());


        QuantityCol.setCellFactory(column -> new TableCell<Stocks, TextField>() {
            final TextField quantityField = new TextField();

            @Override
            protected void updateItem(TextField item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(quantityField);
                    Stocks stock = getTableView().getItems().get(getIndex());
                    quantityFieldsMap.put(stock, quantityField);
                }
            }
        });

        BuyColumn.setCellFactory(column -> new TableCell<Stocks, Button>() {
            final Button buyButton = new Button("Buy");

            {
                buyButton.setOnAction(event -> {
                    Stocks stock = getTableView().getItems().get(getIndex());
                    TextField quantityField = quantityFieldsMap.get(stock);
                    if (quantityField != null) {
                        String quantity = quantityField.getText();
                        if (!quantity.isEmpty()) {
                            try {
                                int purchasedQuantity = Integer.parseInt(quantity);
                                if (purchasedQuantity <= stock.getStockNumber()) {
                                    int remainingStock = stock.getStockNumber() - purchasedQuantity;
                                    System.out.println("Buying " + purchasedQuantity + " of " + stock.getStockName());
                                    System.out.println("Remaining stock of " + stock.getStockName() + ": " + remainingStock);
                                    stock.setStockNumber(remainingStock);
                                    writeDataToFile(stocksList);
                                    tableView.refresh();
                                } else {
                                    System.out.println("Not enough stock available.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }
                        } else {
                            System.out.println("Please enter a quantity.");
                        }
                    }
                });
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buyButton);
                }
            }
        });

        readDataFromFile();
    }

    

    public void writeDataToFile(ArrayList<Stocks> stocksList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Ziiad//Downloads//testfile.csv", false))) {
            for (Stocks stock : stocksList) {
                String line = stock.getStockName() + "," + stock.getInitialPrice() + "," + stock.getStockNumber() + "," + stock.getPrice() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
