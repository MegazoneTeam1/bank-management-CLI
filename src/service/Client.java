package service;

import domain.Account.AccountBuilder;
import view.BankingView;
import view.MenuView;
import view.UserView;

public class Client {
    private final MenuView mainMenu = new MenuView();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final UserView userView = new UserView();
    private final BankingView bankingView = new BankingView();
    private final AccountService accountService = new AccountServiceImpl();


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
                    break;
                case 4:
                    return;
                default:
                    userView.wrongInput();

            }
        }
    }

    public void accountPage(String userid) {
        while (true) {
            int choice = bankingView.bankingService();
            switch (choice) {
                case 1:
                    AccountBuilder account = new AccountBuilder().userId(userid);
                    accountService.createAccount(account);
                    break;
                case 2:
                    break;
                case 3:
                    accountService.getTotalBalance(userid);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    userView.wrongInput();
            }
        }
    }
}
