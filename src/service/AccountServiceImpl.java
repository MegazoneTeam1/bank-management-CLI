package service;

import domain.Account.Account;
import domain.User;
import repository.AccountRepositoryImpl;
import view.AccountView;
import view.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    final private int ACCOUNTLENGTH = 1000000000;
    AccountView accountView = new AccountView();
    PrintUtil printUtil = new PrintUtil();
    @Override
    public boolean createAccount(Account account) {
        User user = new User();

        accountView.startPrint();
        setAccountNum(account);


        //비밀번호 사용자에게서 받기
        String password = accountView.printPw();

        //비밀번호 4자리 체크
        while(checkPasswordLength(password)){
            //다시 입력
            password = accountView.printPwAgain();
        }
        //비밀번호 삽입
        account.setPassword(password);

        //비밀번호 확인
        while (checkPassword(password));

        //게좌생성, 개좌저장소에 저장소
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.save(account);
        return false;
    }

    @Override
    public List<Account> getAccountsByUserId(String userId) {
        List<Account> accounts = new ArrayList<>();
        return List.of( );
    }

    @Override
    public double getTotalBalance(String userId) {
        return 0;
    }

    public boolean checkAccountNum(String accountNumber){
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        Account a = accountRepository.findByAccountNumber(accountNumber);
        if(a == null){ return false; }
        else return true;

    }
    public boolean checkPasswordLength(String password){
        if(password.length() !=4) return true;
        return false;
    }
    public boolean checkPassword(String password){
        String checkPw = accountView.printCheckPw();
        if(checkPw.equals(password)) return false;
        else {
            accountView.wrongPw();
            return true;
        }
    }

    public void setAccountNum(Account account){
        //계좌 랜덤 번호 생성
        int accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        //계좌 중복 체크
        while (checkAccountNum(String.valueOf(accountNumber))) {
            accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        }
        accountView.printAccount(accountNumber);
        //계좌 번호 삽입
        account.setAccountNumber(String.valueOf(accountNumber));


    }

    public static void main(String[] args) {
        Account account = new Account();
        AccountServiceImpl accountService = new AccountServiceImpl();

        accountService.createAccount(account);

    }

}
