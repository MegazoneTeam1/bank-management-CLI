package repository;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    List<User> users = new ArrayList<>();

    // User 정보 저장
    @Override
    public void save(User user) {
        users.add(user);
    }

    /** List 에 저장된 데이터와 user 의 getId() 와 비교하여 id 가 같으면 같은 값의 첫번째 값을 반환하고 아니면 null 을 반환.  */
    @Override
    public User findById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
