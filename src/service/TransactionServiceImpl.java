package service;

import domain.Account.Account;
import domain.Transaction;

import repository.AccountRepositoryImpl;
import repository.TransactionRepositoryImpl;
import view.DepositeView;
import view.PrintUtil;

import java.time.LocalDate;
import java.util.List;
import view.TransactionView;

public class TransactionServiceImpl implements TransactionService {

    private final static DepositeView depositeView = new DepositeView();
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    TransactionView transactionView = new TransactionView();


    // 입금
    @Override
    public boolean deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            depositeView.depositsuccess();
            LocalDate nowDate = LocalDate.now();
            Transaction depoTrans = new Transaction(accountNumber, amount, nowDate, "입금", account.getBalance());
            transactionRepository.save(depoTrans);
            PrintUtil.println(depoTrans.toString());
        } else {
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
                if(account.getBalance() >= amount){
                    account.setBalance(account.getBalance() - amount);}
                else {
                    depositeView.insufficientBalance();
                }
                depositeView.withdrawSuccess();
                LocalDate nowDate = LocalDate.now();
                Transaction withdrawTrans = new Transaction(accountNumber,amount,nowDate,"출금", account.getBalance());
                transactionRepository.save(withdrawTrans);
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
        List<Transaction> transactionHistory = transactionRepository.findTransactionsByAccountNumber(
            accountNumber);
        for (Transaction transaction : transactionHistory) {
            transactionView.transactionHistoryPrint(transaction);
        }
        return transactionHistory;
    }

}