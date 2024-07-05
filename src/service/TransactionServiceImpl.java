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

    // 미구현
    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
         return null ;
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