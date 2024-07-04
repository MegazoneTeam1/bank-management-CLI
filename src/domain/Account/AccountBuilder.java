package domain.Account;

public class AccountBuilder {
    private String accountNumber;
    private String password;
    private String name;
    private String userId;

    public AccountBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }
    public AccountBuilder password(String password) {
        this.password = password;
        return this;
    }
    public AccountBuilder name(String name) {
        this.name = name;
        return this;
    }
    public AccountBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }
    public Account build() {
        return new Account(accountNumber,password,name,userId);
    }

}
