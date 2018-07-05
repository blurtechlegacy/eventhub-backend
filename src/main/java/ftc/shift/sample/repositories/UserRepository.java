package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;

import java.util.Collection;

public interface UserRepository {

  User fetchUser(String id);

  User updateUser(User user);

  void deleteUser(String id);

  User createUser(User user);

  Collection<User> getAllUsers();
}