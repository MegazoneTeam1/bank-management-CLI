package service;

import domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private Map<String,User> userStore = new HashMap<>();
    @Override
    public void updatePhoneNumber (User user, String newPhoneNumber) {
        if(newPhoneNumber == null || newPhoneNumber.isEmpty()) {
            System.out.println("입력한 전화번호가 유효하지 않습니다. ");
            return;
        }
        user.setPhoneNumber(newPhoneNumber);
    }

    @Override
    public void updatePassword (User user, String newPassword) {
        if(newPassword == null || newPassword.isEmpty()) {
            System.out.println("입력한 비밀번호가 유효하지 않습니다.");
            return;
        }
        user.setPassword(newPassword);
    }

    @Override
    public boolean registerUser(User user) {
        if(userStore.containsKey(user.getId())) {
            return false;
        }
        userStore.put(user.getId(), user);
        return true;
    }
    @Override
    public User login(String id, String password) {
        User user = userStore.get(id);
        if( user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    @Override
    public boolean updateUser(User user) {
        if(!userStore.containsKey(user.getId())) {
            return false;
        }
        userStore.put(user.getId(), user);
        return true;
    }
}
