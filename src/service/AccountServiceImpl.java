package service;

import domain.Account.Account;
import domain.User;
import repository.AccountRepository;
import repository.AccountRepositoryImpl;
import view.AccountView;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    final static private int ACCOUNTLENGTH = 1000000000;
    final static private int PWLENGTH = 4;
    private AccountView accountView;
    private AccountRepositoryImpl accountRepository;

    public AccountServiceImpl() {
        this.accountRepository = new AccountRepositoryImpl();
        this.accountView = new AccountView();
    }

    @Override
    public boolean createAccount(Account account) {
        User user = new User();

        accountView.startPrint();
        //계좌 10자리 랜덤 생성
        setAccountNum(account);

        //비밀번호 사용자에게서 받기
        String password = getPasswordToUser();

        //비밀번호 삽입
        account.setPassword(password);

        //비밀번호 확인
        checkPasswordAgain(password);

        //계좌생성, 계좌저장소에 저장소
        accountRepository.save(account);
        return false;
    }

    @Override
    //아직 미구현
    public List<Account> getAccountsByUserId(String userId) {
        List<Account> accounts = new ArrayList<>();
        return List.of( );
    }
    //아직 미구현
    @Override
    public double getTotalBalance(String userId) {
        return 0;
    }
    /**@계좌번호 중복 확인*/
    public boolean checkAccountNum(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber)!= null;
    }

    /**@비밀번호 4자리 체크*/
    public String checkPasswordLength(String password){
        while(password.length() != PWLENGTH){
            //다시 입력
            password = accountView.printPasswordAgain();
        }
        return password;
    }
    /**@비밀번호를 사용자로부터 받기*/
    public String getPasswordToUser(){
        String password = accountView.printPassword();
        return checkPasswordLength(password);
    }
    /**@비밀번호 재확인*/
    public boolean checkPasswordAgain(String password) {
        String checkPassword = accountView.printCheckPassword();
        while(!checkPassword.equals(password)){
            accountView.wrongPassword();
            checkPassword = accountView.printCheckPassword();
        }
        return true;
    }
   /**@계좌 생성에 삽입*/
    public void setAccountNum(Account account){
        //계좌 번호 생성
        String accountNumber = generateUniqueAccountNumber();
        accountView.printAccount(Integer.parseInt(accountNumber));
        //계좌 번호 삽입
        account.setAccountNumber(accountNumber);
    }
    /**@계좌번호 랜덤으로 10자리 받기*/
    public String generateUniqueAccountNumber(){
        int accountNumber;
        do {
            accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        }while (checkAccountNum(String.valueOf(accountNumber)));
        return String.valueOf(accountNumber);
    }

}
