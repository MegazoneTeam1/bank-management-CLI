public class Account {
    private int accountNumber;
    private int password;
    private int money;

    Account(int accountNumber, int password, int money) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.money = money;
    }

    int getAccountNumber() { return accountNumber;}
    int getPassword() { return password;}
    int getMoney() { return money;}

    void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber;}
    void setPassword(int password) { this.password = password;}
    void setMoney(int money) { this.money = money;}
}
