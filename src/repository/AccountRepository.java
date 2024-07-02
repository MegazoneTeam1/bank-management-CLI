package repository;

import domain.Account.Account;
import java.util.List;

public interface AccountRepository {
    void save(Account account);
    Account findByAccountNumber(String accountNumber);
    List<Account> findAllByUserId(String userId);
    void update(String accountNumber,String changeName);

}
