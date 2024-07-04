package service;

import domain.Account.Account;
import domain.Account.AccountBuilder;

import java.util.List;

public interface AccountService {
    List<Account> getAccountsByUserId(String userId);
}
