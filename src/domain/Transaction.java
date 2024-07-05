package domain;

import java.time.LocalDate;

public class Transaction {

    private final String accountNumber;
    private double amount;
    private LocalDate date;
    private String type;

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getType() {
        return type; 
    }
    public LocalDate getDate() {
        return date;
    }
    public double getAmount() {
        return amount; 
    }

    public Transaction(String accountNumber, double amount, LocalDate date, String type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString() {
        return "거래내역  [ " +
                "계좌번호 : '" + accountNumber + '\'' +
                ", 금액 : " + (int)amount +
                ", 날짜 : " + date +
                ", 타입 : '" + type + '\'' +
                ']';
    }

}
