package service;

import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import view.PrintUtil;
import view.UserView;


public class UserServiceImpl implements UserService{
    UserView userView = new UserView();

    // 유저 회원 가입
    @Override
    public boolean registerUser(User user) {
        return true;
    }

    // 유저 로그인
    @Override
    public User login(String id, String password) {
        return null;
    }

    // 유저 업데이트
    @Override
    public boolean updateUser(User user) {
       String newPhoneNumber =  userView.updatePhoneNumberPrint();
       user.setPhoneNumber(newPhoneNumber);

       String newPassword =  userView.updatePasswordPrint();
       user.setPassword(newPassword);

       userView.updateUserPrint();

        return true;
    }
}

