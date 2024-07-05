package domain.Account;

public class Account {
    private final String accountNumber;
    private final String password;
    private String name;
    private double balance;
    private final String userId;


    protected Account(String accountNumber, String password, String name, String userId) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.balance = 0;
        this.userId = userId;
    }

    public String getAccountNumber() {return accountNumber;}
    public String getPassword() {return password;}
    public double getBalance() {return balance;}

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserId() {return userId;}
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
