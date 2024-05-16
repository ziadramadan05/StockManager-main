import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Stocks {
    private int stockNumber;
    private  int price;
    private String stockName;
    private int initialPrice;
    private int currentPrice;
    private int availableStock;
    private Button buyButton;
    private TextField quantityField;

    private int quantityToSell; // New property for the quantity you want to sell
    private Button sellButton; // New property for the sell button

    public Stocks(String stockName, int initialPrice, int stockNumber, int price, Button buyButton, TextField quantityField) {
        this.stockName = stockName;
        this.initialPrice = initialPrice;
        this.stockNumber = stockNumber;
        this.price = price;
        this.buyButton = buyButton;
        this.quantityField = quantityField;
    }


    public Stocks(String stockName, int initialPrice, int currentPrice, int availableStock) {
        this.stockName = stockName;
        this.initialPrice = initialPrice;
        this.currentPrice = currentPrice;
        this.availableStock = availableStock;
    }

    // Getters and setters

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    // Getters and setters for new properties

    public int getQuantityToSell() {
        return quantityToSell;
    }

    public void setQuantityToSell(int quantityToSell) {
        this.quantityToSell = quantityToSell;
    }

    public Button getSellButton() {
        return sellButton;
    }

    public void setSellButton(Button sellButton) {
        this.sellButton = sellButton;
    }


    //


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Button getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(Button buyButton) {
        this.buyButton = buyButton;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(TextField quantityField) {
        this.quantityField = quantityField;
    }

}
