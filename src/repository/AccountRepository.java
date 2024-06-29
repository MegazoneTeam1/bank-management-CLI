package repository;

import domain.Account;
import java.util.List;

public interface AccountRepository {
    void save(Account account);
    Account findByAccountNumber(String accountNumber);
    List<Account> findAllByUserId(String userId);
    void update(Account account);

}
