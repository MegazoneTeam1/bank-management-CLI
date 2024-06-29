package service;

import domain.Account;
import java.util.List;

public interface AccountService {

    boolean createAccount(Account account);

    List<
        Account> getAccountsByUserId(String userId);

    double getTotalBalance(String userId);
}
