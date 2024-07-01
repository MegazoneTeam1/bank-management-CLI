package service;

import domain.User;

public interface UserService {
    boolean registerUser(User user);
    User login(String id, String password);
    boolean updateUser(User user);

    // 전화번호와 비밀번호 변경시 update
    void updatePassword(User user, String newPassword);
    void updatePhoneNumber(User user, String newPhoneNumber);
}