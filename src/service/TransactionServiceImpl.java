package service;

import domain.Account.Account;
import domain.Transaction;

import repository.AccountRepositoryImpl;
import repository.TransactionRepositoryImpl;
import view.Banking;
import view.DepositeView;
import view.PrintUtil;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

     private final static DepositeView depositeView = new DepositeView();
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    private final Banking banking = new Banking();


    // 입금
    @Override
    public boolean deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account != null){
            account.setBalance(account.getBalance()+amount);
            accountRepository.save(account);
            depositeView.depositsuccess();
            LocalDate nowDate =LocalDate.now();
            Transaction depoTrans = new Transaction(accountNumber,amount, nowDate , "입금");
            transactionRepository.save(depoTrans);
            PrintUtil.println(depoTrans.toString());
        } else{
            depositeView.nonSuccessDeposite();
        }
        return false;
    }


    // 출금
    @Override
    public boolean withdraw(String accountNumber, String password, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account != null){
            if(account.getPassword().equals(password)){
                account.setBalance(account.getBalance() - amount);
                depositeView.withdrawSuccess();
                LocalDate nowDate = LocalDate.now();
                Transaction withdrTrans = new Transaction(accountNumber,-amount,nowDate,"출금");
                transactionRepository.save(withdrTrans);
                PrintUtil.println(withdrTrans.toString());
            } else {
                depositeView.nonEqualPassword();
            }
        }else {
            depositeView.nonSuccessDeposite();
        }
        return false;
    }

    // 계좌번호에 따른 거래내역 조회 메소드
    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        List<Transaction> transactionHistory = transactionRepository.findTransactionsByAccountNumber(accountNumber);
        for(Transaction transaction : transactionHistory) {
            transactionView.transactionHistoryPrint(transaction);
        }
        return transactionHistory;
    }
  
    // 사용자의 계좌 정보를 accountRepository 에서 가져오고
    // 계좌정보 저장소가 비어있거나 계좌가 없을 경우 아래와 같은 출력문을 출력,
    public List<Account> findAccountsByUser(String userId) {
        List<Account> accountStore = accountRepository.findAllByUserId(userId);
        if (accountStore.isEmpty()) {
            System.out.println("존재하지 않는 계좌정보 입니다.");
        } else {
            // 존재할 경우 계좌를 출력함.
            for (Account account : accountStore) {
                System.out.println(account.getAccountNumber());
            }
        }
        return accountStore;
    }

    // 입금, 출금 실행
    public void service() {
        switch (banking.bankingService()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:  //입금
                depositeView.startDeposite();
                String depoAccount = depositeView.depositeAccount();
                int depoAmount = depositeView.depositeAmount();
                deposit(depoAccount,depoAmount);
                break;
            case 5:  //출금
                depositeView.startWithdraw();
                String wdAccount = depositeView.withdrawAccount();
                String wdPassword = depositeView.withdrawPassword();
                int wdAmount = depositeView.withdrawAmount();
                withdraw(wdAccount,wdPassword,wdAmount);
                break;
            case 6:
                return;
            default:
                PrintUtil.println("잘못된 입력입니다.");
                PrintUtil.println("");
        }
    }
}