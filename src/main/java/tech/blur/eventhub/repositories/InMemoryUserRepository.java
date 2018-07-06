package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> userCache = new HashMap<>();

    public InMemoryUserRepository() {
        userCache.put("1", new User("1", "MacOSO", "verystrongpassword", "Alexandr", "1999-10-26", 1));
        userCache.put("2", new User("2", "SrgGrch", "qwer2017", "Sergey", "1999-09-28", 1));
    }


    @Override
    public User fetchUser(final String id) {
        return userCache.get(id);
    }

    @Override
    public User updateUser(final User user) {
        userCache.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(final String id) {
        userCache.remove(id);
    }

    @Override
    public User createUser(final User user) {
        user.setId(String.valueOf(System.currentTimeMillis()));  //очень плохой способ генерировать Id, тут только для примера
        userCache.put(user.getId(), user);
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userCache.values();
    }
}
