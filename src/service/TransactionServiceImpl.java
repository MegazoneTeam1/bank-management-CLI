package service;

import domain.Account;
import domain.Transaction;
import repository.AccountRepositoryImpl;
import repository.TransactionRepository;
import repository.TransactionRepositoryImpl;
import view.DepositeView;
import view.PrintUtil;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

     private static DepositeView depositeView;
     private static TransactionRepositoryImpl transactionRepository;
    Transaction transaction ;
    Account account= new Account();




    @Override
    public boolean deposit(String accountNumber, double amount) {

        // 저장소의 계좌번호와 입력의 계좌번호가 같으면, balance = balance + 입금액
        if(account.getAccountNumber().equals(accountNumber)){
            account.setBalance(account.getBalance() + amount);
        }
        // 저장소에 저장
        transactionRepository.save(transaction);
        return false;
    }

    // 출금
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
         return null ;
    }




}