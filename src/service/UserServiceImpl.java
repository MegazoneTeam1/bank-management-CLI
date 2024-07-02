package service;

import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import view.Banking;
import view.MainMenu;
import view.UserView;


public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepositoryImpl();
    Banking banking = new Banking();
    UserView userView = new UserView();


    /** 사용자 등록시 아이디가 있으면
     * false 로 반환하여 사용자 등록 실패, 아니면 true 반환하여 사용자 등록 */
    @Override
    public boolean registerUser(User user) {
        userRepository.save(user);
        return true;

    }
    /** 사용자의 아이디가 있을 때
     * 사용자가 null 이 아니고 사용자의 비밀번호가 입력받은 비밀번호와 같으면 로그인 성공
     * 없을경우 null 을 반환하여 로그인 실패*/
    @Override
    public User login(String id, String password) {
        User user = userRepository.findById(id);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /***/
    @Override
    public boolean updateUser(User user) {
        return true;
    }

    public boolean duplicateID(String id) {
        User user = userRepository.findById(id);
        if (user != null) {
            return true;
        }
        return false;
    }

    public void signup() {
        String name = null;
        while (true) {
            name = userView.inputName();
            if(name.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }

        String phoneNumber = null;
        while (true) {
            phoneNumber = userView.inputphoneNumber();
            if(phoneNumber.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }


        String id = null;
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

        /** 무한반복문을 통해 비밀번호가 6자리가 아닐경우 다시 설정하고, 6자리가 맞으면 break 를 통해 회원가입이 성공.*/
        String password = null;
        while (true) {
            password = userView.inputPassword();
            if(password.length() == 6) {
                break;
            } else {
                userView.reEnterPassword();
            }
        }

        User newuser = new User(name, phoneNumber, id, password);

        /** 새로운 사용자 데이터를 입력받고 리스트에 저장하여 사용자 등록 */
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
        banking.bankingservice();
    }
}
