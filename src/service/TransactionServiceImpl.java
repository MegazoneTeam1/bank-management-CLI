package service;

import domain.Account.Account;
import domain.Transaction;
import repository.AccountRepository;
import repository.AccountRepositoryImpl;
import repository.TransactionRepository;
import repository.TransactionRepositoryImpl;
import view.TransactionView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionServiceImpl implements TransactionService {
    private List<Transaction> transactions = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    AccountRepository accountRepository = new AccountRepositoryImpl();
    TransactionRepository transactionRepository = new TransactionRepositoryImpl();
    TransactionView transactionView = new TransactionView();

    // 사용자의 계좌 정보를 accountRepository 에서 가져오고
    // 계좌정보 저장소가 비어있거나 계좌가 없을 경우 아래와 같은 출력문을 출력,
    public List<Account> findaccountsByUser(String userId) {
        List<Account> accountStore = accountRepository.findAllByUserId(userId);
        if (accountStore.isEmpty()) {
            System.out.println("존재하지 않는 계좌정보 입니다.");
        } else {
            // 존재할 경우 계좌를 출력함.
            for (Account account : accountStore) {
                System.out.println(account.getAccountNumber());
            }
        }
        return accountStore;
    }

    // 계좌번호에 따른 거래내역 조회 메소드
    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        List<Transaction> transactionHistory = transactionRepository.findTransactionsByAccountNumber(accountNumber);
        for(Transaction transaction : transactionHistory) {
            transactionView.transactionHistoryPrint(transaction);
        }
        return transactionHistory;
    }

    @Override
    // 입금 메소드
    public boolean deposit(String accountNumber, double amount) {
        return false;
    }

    // 출금 메소드
    @Override
    public boolean withdraw(String accountNumber, String password, double amount) {
        return false;
    }
}
