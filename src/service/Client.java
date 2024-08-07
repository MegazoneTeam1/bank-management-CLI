package service;

import domain.Account.AccountBuilder;
import view.BankingView;
import view.DepositView;
import view.MenuView;
import view.TransactionView;
import view.UserView;

public class Client {
    private final MenuView mainMenu = new MenuView();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final UserView userView = new UserView();
    private final BankingView bankingView = new BankingView();
    private final AccountService accountService = new AccountServiceImpl();
    private final DepositView depositView = new DepositView();
    private final TransactionView transactionView = new TransactionView();

    private final TransactionServiceImpl transactionService= new TransactionServiceImpl();


    public void mainPage() {
        while (true) {
            int choice = mainMenu.showMenu();
            switch (choice) {
                case 1:
                    userService.signUp();
                    break;
                case 2:
                    String id = userService.loginMenu();
                    if (!id.isEmpty()) {
                        accountPage(id);
                    }
                    break;
                case 3:
                    return;
                default:
                    userView.wrongInput();

            }
        }
    }

    public void accountPage(String userId) {
        while (true) {
            int choice = bankingView.bankingService();
            switch (choice) {
                case 1:
                    AccountBuilder account = new AccountBuilder().userId(userId);
                    accountService.createAccount(account);
                    break;
                case 2:
                    accountService.accountNumList(userId);
                    break;
                case 3:
                    transactionService.getTransactionsByAccountNumber(
                        transactionView.getAccountNumberByClient());
                    break;
                case 4:
                    depositView.startDeposit();
                    String depositAccount = depositView.depositAccount();
                    int depositAmount = depositView.depositAmount();
                    transactionService.deposit(depositAccount,depositAmount);
                    break;
                case 5:
                    depositView.startWithdraw();
                    String withdrawAccount = depositView.withdrawAccount();
                    String withdrawPassword = depositView.withdrawPassword();
                    int withdrawAmount = depositView.withdrawAmount();
                    transactionService.withdraw(withdrawAccount,withdrawPassword,withdrawAmount);
                    break;
                case 6:
                    userService.updateUser(userId);
                    break;
                case 7:
                    return;
                default:
                    userView.wrongInput();
            }
        }
    }
}
