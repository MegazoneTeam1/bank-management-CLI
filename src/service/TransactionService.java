package service;

import domain.Transaction;
import java.util.List;

public interface TransactionService {

    boolean deposit(String accountNumber, double amount);

    boolean withdraw(String accountNumber, String password, double amount);

    List<Transaction> getTransactionsByAccountNumber(String accountNumber);

}
