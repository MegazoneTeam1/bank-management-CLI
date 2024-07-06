package service;

import domain.Account.Account;
import domain.Account.AccountBuilder;
import repository.AccountRepositoryImpl;
import view.AccountView;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    final static private int ACCOUNTLENGTH = 1000000000;
    final static private int PWLENGTH = 4;
    private final AccountView accountView;
    private final AccountRepositoryImpl accountRepository;

    public AccountServiceImpl() {
        this.accountRepository = new AccountRepositoryImpl();
        this.accountView = new AccountView();
    }

    @Override
    public boolean createAccount(AccountBuilder account) {
        accountView.startPrint();
        //계좌 10자리 랜덤 생성
        setAccountNumber(account);

        //계좌 이름 지정
        accountNameSet(account);

        //비밀번호 사용자에게서 받기
        String password = getPasswordToUser();

        //비밀번호 삽입
        account.password(password);

        //비밀번호 확인
        checkPasswordAgain(password);

        //계좌생성, 계좌저장소에 저장소
        accountRepository.save(account.build());
        accountView.printAccountCreateSuccess();
        return false;
    }

    @Override
    public void accountNumList(String userId){
        List<Account> accounts =accountRepository.findAllByUserId(userId);
        for(Account account : accounts){
            accountView.printAccountList(account);
        }
    }

    /**계좌번호 중복 확인*/
    public boolean checkAccountNum(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber)!= null;
    }

    /**비밀번호 4자리 체크*/
    public String checkPasswordLength(String password){
        while(password.length() != PWLENGTH){
            //다시 입력
            password = accountView.printPasswordAgain();
        }
        return password;
    }
    /**비밀번호를 사용자로부터 받기*/
    public String getPasswordToUser(){
        String password = accountView.printPassword();
        return checkPasswordLength(password);
    }
    /**비밀번호 재확인*/
    public void checkPasswordAgain(String password) {
        String checkPassword = accountView.printCheckPassword();
        while(!checkPassword.equals(password)){
            accountView.wrongPassword();
            checkPassword = accountView.printCheckPassword();
        }
    }
   /**계좌 생성에 삽입*/
    public void setAccountNumber(AccountBuilder account){
        //계좌 번호 생성
        String accountNumber = generateUniqueAccountNumber();
        accountView.printAccount(Integer.parseInt(accountNumber));
        //계좌 번호 삽입
        account.accountNumber(accountNumber);
    }
    /**계좌번호 랜덤으로 10자리 받기*/
    public String generateUniqueAccountNumber(){
        int accountNumber;
        do {
            accountNumber = (int) (Math.random() * ACCOUNTLENGTH)+ACCOUNTLENGTH;
        }while (checkAccountNum(String.valueOf(accountNumber)));
        return String.valueOf(accountNumber);
    }
    /**계좌이름 유저에게 받기*/
    public void accountNameSet(AccountBuilder account){
        String nameAccount = accountView.printSetName();
        account.name(nameAccount).build();
    }
    /**계좌이름 변경*/
    public void update() {

        String accountNumber= accountView.startGetAccountNumber();
        Account account = accountRepository.findByAccountNumber(accountNumber);
        try{
            account.getName();
        }catch(NullPointerException e){
            accountView.printNullError();
        }
        String changeName = accountView.printSetName();
        account.setName(changeName);
    }



}
