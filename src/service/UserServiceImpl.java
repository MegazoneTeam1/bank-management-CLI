package service;

import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepositoryImpl();

    /** 사용자 등록시 아이디가 있으면
     * false 로 반환하여 사용자 등록 실패, 아니면 true 반환하여 사용자 등록 */
    @Override
    public boolean registerUser(User user) {
        if(userRepository.findById(user.getId()) != null) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
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
}
