package repository;

import domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements  TransactionRepository{
    private static final List<Transaction> transactions = new ArrayList<>();
    @Override
    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findTransactionsByAccountNumber(String accountNumber) {
        return transactions.stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber)).toList();
    }
}
