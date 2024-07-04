package repository;

import domain.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRepositoryImpl implements  TransactionRepository{
    private static final List<Transaction> transactions = new ArrayList<>();

    // 거래내역 저장
    @Override
    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    //  계좌번호로 거래내역 찾아서 조회
    @Override
    public List<Transaction> findTransactionsByAccountNumber(String accountNumber) {
        return transactions.stream().filter(transaction -> transaction.getAccountNumber().equals(accountNumber)).collect(Collectors.toList());
    }
}
