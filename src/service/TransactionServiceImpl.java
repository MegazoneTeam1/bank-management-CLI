package service;

import domain.Account.Account;
import domain.Transaction;
import repository.AccountRepositoryImpl;
import repository.TransactionRepositoryImpl;
import view.Banking;
import view.DepositeView;
import view.PrintUtil;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

     private final static DepositeView depositeView = new DepositeView();
     private final static TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
    private final Transaction transaction = new Transaction() ;

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    private final Banking banking = new Banking();



    @Override
    public boolean deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        // 저장소의 계좌번호와 입력의 계좌번호가 같으면, balance = balance + 입금액
        if(account != null){
            account.setBalance(account.getBalance()+amount);
            transactionRepository.save(transaction);
            depositeView.depositsuccess();
            PrintUtil.println("계좌번호: "+account.getAccountNumber() + "  잔고: " + (int)account.getBalance());
        } else{
            depositeView.nonSuccessDeposite();
        }
        // 저장소에 저장
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
                PrintUtil.println("계좌번호: "+account.getAccountNumber() + "  잔고: " + (int)account.getBalance());

            } else {
                depositeView.nonEqualPassword();
            }
        }else {
            depositeView.nonSuccessDeposite();
        }
        return false;
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
         return null ;
    }

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