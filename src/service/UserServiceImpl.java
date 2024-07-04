package service;

import domain.Account.AccountBuilder;
import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import view.Banking;
import view.MainMenu;
import view.UserView;

public class UserServiceImpl implements UserService {

    final static private int LENGTH_PASSWORD = 6;

    UserRepository userRepository = new UserRepositoryImpl();
    Banking banking = new Banking();
    UserView userView = new UserView();
    MainMenu mainMenu = new MainMenu();
    AccountService accountService = new AccountServiceImpl();

    /**
     *
     * @param user user를 List에 저장
     * @return true를 반환하여 사용자 등록
     */
    @Override
    public boolean registerUser(User user) {
        userRepository.save(user);
        return true;

    }

    /**
     *
     * @param id List에 user id가 있고
     * @param password List에 user가 null이 아니고 비밀번호가 일치하면
     * @return user를 반환, 없을 시 null을 반환
     */
    @Override
    public User login(String id, String password) {
        User user = userRepository.findById(id);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // 미구현
    @Override
    public boolean updateUser(User user) {
        return true;
    }

    /**
     *
     * @param id List에 있는 id와 비교
     * @return null이 아니면 true, null이면 false를 반환
     */
    public boolean duplicateID(String id) {
        User user = userRepository.findById(id);
        if (user != null) {
            return true;
        }
        return false;
    }


    public void signUp() {
        String name;
        while (true) {
            name = userView.inputName();
            if(name.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }

        String phoneNumber;
        while (true) {
            phoneNumber = userView.inputPhoneNumber();
            if(phoneNumber.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }


        String id;
        while (true) {
            id = userView.inputId();
            if(id.isEmpty()) {
                userView.reEnter();
            } else if(duplicateID(id)) {
                userView.duplicateId();
            } else {
                break;
            }
        }

        String password;
        while (true) {
            password = userView.inputPassword();
            if(password.length() == LENGTH_PASSWORD) {
                break;
            } else {
                userView.reEnterPassword();
            }
        }

        User newuser = new User(name, phoneNumber, id, password);

        if(registerUser(newuser)) {
            userView.successSignup();
        } else  {
            userView.failSignup();
        }


    }

    public void loginMenu() {
        String id = userView.inputId();
        String password = userView.inputPassword();
        /** 입력받은 id와 password 를 통해 로그인 성공 실패 확인. */
        /** 로그인에 성공하면 계좌관련 메뉴로 이동, 로그인에 실패하면 return 되어 menu 로 돌아감.*/
        User user = login(id, password);
        if(user == null) {
            userView.failLogin();
            return;
        } else
            userView.successLogin();
        accountPage(id);
    }


    public void mainPage() {

        while (true) {
            int choice = mainMenu.showMenu();
            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    userView.wrongInput();
                    userView.blank();

            }
        }
    }

    public void accountPage(String userid) {
        while (true) {
            int choice = banking.bankingService();
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
                    userView.blank();
            }
        }
    }
}


