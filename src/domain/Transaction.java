package domain;

import java.time.LocalDate;

public class Transaction {
    private String accountNumber;
    private double amount;
    private LocalDate date;
    private String type;

    public Transaction(LocalDate date, String accountNumber, double amount, String type) {
        this.date = date;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }
    public String getAccountNumber() {  return accountNumber; }
    public String setAccountNumber(String accountNumber) {return this.accountNumber = accountNumber;}

    public double getAmount() { return amount; }
    public double setAmount(double amount) { return amount; }

    public LocalDate getDate() {  return date;}
    public LocalDate setDate(LocalDate date) { return date; }

    public String getType() {  return type; }
    public String setType(String type) { return this.type = type; }

}
