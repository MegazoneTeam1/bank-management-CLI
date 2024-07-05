package service;

import domain.User.User;
import domain.User.UserBuilder;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import view.UserView;

public class UserServiceImpl implements UserService {

    final static private int LENGTH_PASSWORD = 6;

    private final UserRepository userRepository = new UserRepositoryImpl();
    private final UserView userView = new UserView();


    /**
     * @param user user를 List에 저장
     * @return true를 반환하여 사용자 등록
     */
    @Override
    public boolean registerUser(User user) {
        userRepository.save(user);
        return true;

    }

    /**
     * @param id       List에 user id가 있고
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

    @Override
    public boolean updateUser(String userId) {
        User user = userRepository.findById(userId);
        String newPhoneNumber = userView.updatePhoneNumberPrint();
        user.setPhoneNumber(newPhoneNumber);
        String newPassword = userView.updatePasswordPrint();

        if (newPassword.length() != LENGTH_PASSWORD) {
            userView.reEnterPassword();
        } else {
            user.setPassword(newPassword);
            userView.updateUserPrint();
            System.out.println("gd");
        }
        return true;
    }

    /**
     * @param id List에 있는 id와 비교
     * @return null이 아니면 true, null이면 false를 반환
     */
    public boolean duplicateID(String id) {
        User user = userRepository.findById(id);
        return user != null;
    }

    private String inputName() {
        String name;
        while (true) {
            name = userView.inputName();
            if (name.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }
        return name;
    }

    private String inputPhoneNumber() {
        String phoneNumber;
        while (true) {
            phoneNumber = userView.inputPhoneNumber();
            if (phoneNumber.isEmpty()) {
                userView.reEnter();
            } else {
                break;
            }
        }
        return phoneNumber;
    }

    private String inputID() {
        String id;
        while (true) {
            id = userView.inputId();
            if (id.isEmpty()) {
                userView.reEnter();
            } else if (duplicateID(id)) {
                userView.duplicateId();
            } else {
                break;
            }
        }
        return id;
    }

    private String inputPassword() {
        String password;
        while (true) {
            password = userView.inputPassword();
            if (password.length() == LENGTH_PASSWORD) {
                break;
            } else {
                userView.reEnterPassword();
            }
        }
        return password;
    }


    public void signUp() {

        User newUser = new UserBuilder()
            .name(inputName())
            .phoneNumber(inputPhoneNumber())
            .id(inputID())
            .password(inputPassword())
            .build();

        if (registerUser(newUser)) {
            userView.successSignup();
        } else {
            userView.failSignup();
        }


    }

    public String loginMenu() {

        String id = userView.inputId();
        String password = userView.inputPassword();
        /** 입력받은 id와 password 를 통해 로그인 성공 실패 확인. */
        /** 로그인에 성공하면 계좌관련 메뉴로 이동, 로그인에 실패하면 return 되어 menu 로 돌아감.*/
        User user = login(id, password);
        if (user == null) {
            userView.failLogin();
            return "";
        } else {
            userView.successLogin();
            return id;
        }

    }
}


