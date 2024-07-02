package repository;

import domain.Account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private static List<Account> accounts = new ArrayList<>();

    /**생성된 계좌 저장*/
    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    /**계좌번호 검색*/
    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    /**유저가 가지는 계좌 조회*/
    @Override
    public List<Account> findAllByUserId(String userId) {
        return accounts.stream().filter(account -> account.getUserId().equals(userId)).collect(Collectors.toList());
    }
    /**계좌 이름 변경*/
    @Override
    public void update(String accountNumber,String changeName) {
        Account account = findByAccountNumber(accountNumber);
        account.setName(changeName);
    }


}
