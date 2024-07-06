package service;

import domain.Account.Account;
import domain.Transaction;

import repository.AccountRepositoryImpl;
import repository.TransactionRepositoryImpl;
import view.DepositView;
import view.PrintUtil;

import java.time.LocalDate;
import java.util.List;
import view.TransactionView;

public class TransactionServiceImpl implements TransactionService {

    private final static DepositView DEPOSIT_VIEW = new DepositView();
    TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    TransactionView transactionView = new TransactionView();


    // 입금
    @Override
    public boolean deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            DEPOSIT_VIEW.depositSuccess();
            LocalDate nowDate = LocalDate.now();
            Transaction depositTransaction = new Transaction(accountNumber, amount, nowDate, "입금", account.getBalance());
            transactionRepository.save(depositTransaction);
            PrintUtil.println(depositTransaction.toString());
        } else {
            DEPOSIT_VIEW.nonSuccessDeposit();
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
                    DEPOSIT_VIEW.insufficientBalance();
                }
                DEPOSIT_VIEW.withdrawSuccess();
                LocalDate nowDate = LocalDate.now();
                Transaction withdrawTransaction = new Transaction(accountNumber,amount,nowDate,"출금", account.getBalance());
                transactionRepository.save(withdrawTransaction);
            } else {
                DEPOSIT_VIEW.nonEqualPassword();
            }
        }else {
            DEPOSIT_VIEW.nonSuccessDeposit();
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