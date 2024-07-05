package repository;

import domain.User.User;
import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(String id);

    List<User> findAll();

}
