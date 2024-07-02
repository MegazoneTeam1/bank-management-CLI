package repository;

import domain.Account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private static List<Account> accounts = new ArrayList<>();

    @Override
    /**생성된 계좌 저장*/
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    /**계좌번호 검색*/
    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    @Override
    /**유저가 가지는 계좌 조회*/
    public List<Account> findAllByUserId(String userId) {
        return accounts.stream().filter(account -> account.getUserId().equals(userId)).collect(Collectors.toList());
    }
    //미구현
    @Override
    public void update(Account account) {

    }
}
