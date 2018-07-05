package ftc.shift.sample.services;

import ftc.shift.sample.models.User;
import ftc.shift.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User provideUser(String id) {
    return userRepository.fetchUser(id);
  }

  public User updateUser(User user) {
    userRepository.updateUser(user);
    return user;
  }

  public void deleteUser(String id) {
    userRepository.deleteUser(id);
  }


  public User createUser(User user) {
    userRepository.createUser(user);
    return user;
  }

  public Collection<User> provideUsers() {
    return userRepository.getAllUsers();
  }

}
