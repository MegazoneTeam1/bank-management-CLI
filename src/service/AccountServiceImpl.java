package service;

import domain.Account.Account;
import domain.Account.AccountBuilder;
import domain.User;
import repository.AccountRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
    final private int ACCOUNTLENGTH = 1000000000;

    @Override
    public boolean createAccount(Account account) {
        User user = new User();
        int accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        while (checkAccountNum(String.valueOf(accountNumber))) {
            accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        }
        account.setAccountNumber(String.valueOf(accountNumber));


        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        account.setPassword(password);

        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.save(account);
        return false;
    }
    @Override
    public List<Account> getAccountsByUserId(String userId) {
        List<Account> accounts = new ArrayList<>();
        return List.of( );
    }

    @Override
    public double getTotalBalance(String userId) {
        return 0;
    }

    public static void main(String[] args) {

    }
    public boolean checkAccountNum(String accountNumber){
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        Account a = accountRepository.findByAccountNumber(accountNumber);
        if(a == null){ return false; }
        return true;

    }
}
