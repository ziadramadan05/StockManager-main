package ClassesLogic;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String email;
    protected static double balance;

    public User(String username, String password, String fullName, String email, double balance) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.balance = balance;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Additional methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
