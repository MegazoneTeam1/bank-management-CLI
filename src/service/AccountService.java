package service;

import domain.Account.AccountBuilder;

public interface AccountService {

    boolean createAccount(AccountBuilder account);

    void accountNumList(String userId);

}
