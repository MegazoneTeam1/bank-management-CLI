package service;

import domain.Account.AccountBuilder;
import view.BankingView;
import view.DepositeView;
import view.MenuView;
import view.TransactionView;
import view.UserView;

public class Client {
    private final MenuView mainMenu = new MenuView();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final UserView userView = new UserView();
    private final BankingView bankingView = new BankingView();
    private final AccountService accountService = new AccountServiceImpl();
    private final DepositeView depositeView = new DepositeView();
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
                        accountPage(id);;
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
                    depositeView.startDeposite();
                    String depoAccount = depositeView.depositeAccount();
                    int depoAmount = depositeView.depositeAmount();
                    transactionService.deposit(depoAccount,depoAmount);
                    break;
                case 5:
                    depositeView.startWithdraw();
                    String wdAccount = depositeView.withdrawAccount();
                    String wdPassword = depositeView.withdrawPassword();
                    int wdAmount = depositeView.withdrawAmount();
                    transactionService.withdraw(wdAccount,wdPassword,wdAmount);
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
