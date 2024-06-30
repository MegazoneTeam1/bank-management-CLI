package service;

import domain.Account;
import domain.Transaction;

public class TransactionServiceImpl implements TransactionService {

    Transaction transaction = new Transaction();
    Account account = new Account();
    public TransactionServiceImpl() {
        super();
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {
        if(account.getAccountNumber().equals(accountNumber)){
            account.setBalance(amount);
        }
        return false;
    }

    @Override
    public boolean withdraw(String accountNumber, String password, double amount) {
        if(account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)){
            if(account.getBalance() >= amount) {
                account.setBalance(amount);
            }
        }
        return false;
    }

    @Override
    public String getTransactionsByAccountNumber(String accountNumber) {
        if(account.getAccountNumber() == accountNumber){
            return accountNumber.toString();
        }else {
            return "존재하지 않는 계좌번호";
        }

    }


}