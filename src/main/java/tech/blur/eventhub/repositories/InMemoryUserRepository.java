package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.UserLoginPass;
import tech.blur.eventhub.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> userCache = new HashMap<>();

    private Map<UserLoginPass, User> userLoginPass = new HashMap<>();

    public InMemoryUserRepository() {
        userCache.put("1", new User("1", "MacOSO", "verystrongpassword", "Саша",
                "1999-10-26", 1));
        userCache.put("2", new User("2", "SrgGrch", "qwer2017", "Серёжа",
                "1999-09-28", 1));
        userCache.put("3", new User("3", "erbol", "dinara120454", "Ербол",
                "1999-11-22", 1));
        userCache.put("4", new User("4", "1", "1", "Матвей",
                "1999-04-20", 1));
        userCache.put("5", new User("5", "28StabWounds", "ilovekonnorrA9", "Маша",
                "1999-04-10", 0));
        userCache.put("6", new User("6", "Puzovoz", "pythonmylife", "Илюша",
                "1999-05-06", 1));
        userCache.put("7", new User("7", "tipKarpenko", " ", "Илья",
                "1999-08-24", 1));
        userLoginPass.put(new UserLoginPass("MacOSO", "verystrongpassword"), new User("1", "MacOSO",
                "verystrongpassword", "Саша", "1999-10-26", 1));
        userLoginPass.put(new UserLoginPass("SrgGrch", "qwer2017"), new User("2", "SrgGrch",
                "qwer2017", "Серёжа","1999-09-28", 1));
        userLoginPass.put(new UserLoginPass("erbol", "dinara120454"), new User("3", "erbol", "dinara120454", "Ербол",
                "1999-11-22", 1));
        userLoginPass.put(new UserLoginPass("1", "1"), new User("4", "1", "1", "Матвей",
                "1999-04-20", 1));
        userLoginPass.put(new UserLoginPass("28StabWounds", "ilovekonnorrA9"), new User("5", "masanya99", "ilovekonnorrA9", "Маша",
                "1999-04-10", 0));
        userLoginPass.put(new UserLoginPass("Puzovoz", "pythonmylife"), new User("6", "Puzovoz", "pythonmylife", "Илюша",
                "1999-05-06", 1));
        userLoginPass.put(new UserLoginPass("tipKarpenko", " "), new User("7", "tipKarpenko", " ", "Илья",
                "1999-08-24", 1));
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
    public User authUser(UserLoginPass userLoginPass) {
        return this.userLoginPass.get(userLoginPass);
    }

    @Override
    public void deleteUser(final String id) {
        userCache.remove(id);
    }

    @Override
    public User createUser(final User user) {
        user.setId(Integer.toString(userCache.size()+1));
        userCache.put(user.getId(), user);
        userLoginPass.put(new UserLoginPass(user.getLogin(), user.getPassword()), user);
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userCache.values();
    }
}
