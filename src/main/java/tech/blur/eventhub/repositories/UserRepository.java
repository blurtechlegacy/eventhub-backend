package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.UserLoginPass;
import tech.blur.eventhub.models.User;

import java.util.Collection;

public interface UserRepository {

  User fetchUser(String id);

  User updateUser(User user);

  User authUser (UserLoginPass userLoginPass);

  void deleteUser(String id);

  User createUser(User user);

  Collection<User> getAllUsers();

}