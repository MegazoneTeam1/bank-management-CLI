package service;

import domain.Account;
import domain.Transaction;
import view.ViewTransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    Account account = new Account();
    public TransactionServiceImpl() {
        super();
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {
        if(account.getAccountNumber().equals(accountNumber)){
            account.setBalance(account.getBalance() + amount);
        }
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

    // 입금 입력받으면 계좌번호, 입금금액 날짜 총금액 출력 메서드


    // 출금 입력받으면 계좌번호, 출금금액 날짜 총금액 출력 메서드

    //상대계좌? - 입금메서드
}