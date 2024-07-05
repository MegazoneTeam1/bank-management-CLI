package repository;

import domain.Transaction;

import java.util.ArrayList;
import java.util.List;

// 거래 내역 정보를 저장하는 저장소 !
public class TransactionRepositoryImpl implements TransactionRepository {
    private static List<Transaction> transactions = new ArrayList<>();
    // 거래 내역 정보를 저장
    @Override
    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
        public List<Transaction> findTransactionsByAccountNumber(String accountNumber) {
            return transactions.stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber)).toList();
        }
    }
