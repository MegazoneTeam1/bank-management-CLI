package repository;

import domain.Transaction;
import java.util.List;

public interface TransactionRepository {

    void save(Transaction transaction);

    List<Transaction> findTransactionsByAccountNumber(String accountNumber);

}
