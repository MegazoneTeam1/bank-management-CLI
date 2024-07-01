package repository;

import domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    private  static List<Account> accounts = new ArrayList<>();


    @Override
    public void save(Account account) {
        accounts.add(account);
    }


    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accounts.get(Integer.parseInt(accountNumber));
    }

    @Override
    public List<Account> findAllByUserId(String userId) {
        return accounts.stream().filter(account -> account.getUserId().equals(userId)).toList();
    }

    /* 미구현 */
    @Override
    public void update(Account account) {

    }
}
