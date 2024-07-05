package service;

import domain.Account.Account;
import domain.Account.AccountBuilder;

import java.util.List;

public interface AccountService {

    boolean createAccount(AccountBuilder account);

    public void accountNumList(String userId);

}
