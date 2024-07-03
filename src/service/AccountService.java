package service;

import domain.Account.Account;
import domain.Account.AccountBuilder;

import java.util.List;

public interface AccountService {

    boolean createAccount(AccountBuilder account);

    List<
        Account> getAccountsByUserId(String userId);

    double getTotalBalance(String userId);
}
