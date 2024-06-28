package repository;

import domain.User;
import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(String id);

    void update(User user);

    List<User> findAll();

}
