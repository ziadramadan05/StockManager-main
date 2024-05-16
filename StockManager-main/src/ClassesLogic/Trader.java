//package ClassesLogic;
//
//import java.util.List;
//
//
//// User.java
// class User {
//    private String username;
//    private String password;
//
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    // Getters and setters for username and password
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
//
//// Trader.java
//public class Trader extends User {
//    private double balance;
//    private List <Stock> stocksOwned;
//
//    public Trader(String username, String password, double balance) {
//        super(username, password);
//        this.balance = balance;
//       // this.stocksOwned = new List<>();
//    }
//
//    // Additional methods specific to Trader class
//    public void buyStock(Stock stock, int quantity) {
//        // Implement logic to buy stock
//    }
//
//    public void sellStock(Stock stock, int quantity) {
//        // Implement logic to sell stock
//    }
//
//    // Getters and setters for balance and stocksOwned
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public List <Stock> getStocksOwned() {
//        return stocksOwned;
//    }
//
//    public void setStocksOwned(List<Stock> stocksOwned) {
//        this.stocksOwned = stocksOwned;
//    }
//}
