package view;

import domain.Account;
import domain.Transaction;
import repository.TransactionRepositoryImpl;
import service.TransactionServiceImpl;

public class TransactionView {
    private static DepositeView depositeView;
    TransactionServiceImpl transactionService = new TransactionServiceImpl();
    Transaction transaction = new Transaction();
    Account account= new Account();
    public void showMenu() {
        String[] option = {"입금", "출금","종료"};
        while (true){
            PrintUtil.println("입출금 시스템");
            int choice = PrintUtil.readInt("메뉴를 선택해주세요: ");
            switch (choice){
                case 1:
                    depositeView.startDeposite();
                    String accountDP = depositeView.depositeAccount();
                    int amountDP = depositeView.depositeAmount();
                    transactionService.deposit(accountDP,amountDP);
                    depositeView.depositsuccess();
                    break;
                case 2:
                    depositeView.startWithdraw();
                    String accountWD = depositeView.withdrawAccount();
                    String password = depositeView.withdrawPassword();
                    int amountWD = depositeView.withdrawAmount();
                    transactionService.withdraw(accountWD,password,amountWD);
                    depositeView.withdrawSuccess();
                    break;
                case 3:
                    return;
                default:
                    PrintUtil.println("잘못된 입력입니다.");
                    PrintUtil.println("");

            }
        }
    }
}
