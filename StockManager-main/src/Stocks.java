

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Stocks {
    private String stockName;
    private int initialPrice;
    private int stockNumber;
    private int price;
    private Button buyButton;
    private TextField quantityField;

    public Stocks(String stockName, int initialPrice, int stockNumber, int price, Button buyButton, TextField quantityField) {
        this.stockName = stockName;
        this.initialPrice = initialPrice;
        this.stockNumber = stockNumber;
        this.price = price;
        this.buyButton = buyButton;
        this.quantityField = quantityField;
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

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
