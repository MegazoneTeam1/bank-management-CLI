package service;

import domain.Account;
import domain.Transaction;
import repository.AccountRepositoryImpl;
import repository.TransactionRepositoryImpl;
import view.DepositeView;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final DepositeView depositeView;
    private final TransactionRepositoryImpl transactionRepository;
    Transaction transaction = new Transaction();
    Account account = new Account();

    public TransactionServiceImpl(DepositeView depositeView, TransactionRepositoryImpl transactionRepository) {
        this.depositeView = depositeView;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {

        // 입금 시작
        depositeView.startDeposite();
        // 입금 계좌 금액 입력
        depositeView.depositeAccount(accountNumber);
        depositeView.depositeAmount(amount);

        if(account.getAccountNumber().equals(accountNumber)){
            account.setBalance(account.getBalance() + amount);
        }
        transactionRepository.save(transaction);
        depositeView.depositsucess();

        return false;
    }

    @Override
    public boolean withdraw(String accountNumber, String password, double amount) {

        if(account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)){
            if(account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
            }
        }
        return false;
    }



    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {

        return null;
    }


}