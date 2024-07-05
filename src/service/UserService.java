package service;

import domain.User.User;

public interface UserService {
    boolean registerUser(User user);
    User login(String id, String password);
    boolean updateUser(User user);
}