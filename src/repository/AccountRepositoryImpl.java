package repository;

import domain.Account.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private static List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {

        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    @Override
    public List<Account> findAllByUserId(String userId) {
        return List.of();
    }

    @Override
    public void update(Account account) {

    }
}
