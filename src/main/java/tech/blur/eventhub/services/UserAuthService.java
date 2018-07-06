package tech.blur.eventhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.blur.eventhub.models.AuthUser;
import tech.blur.eventhub.models.User;
import tech.blur.eventhub.repositories.UserRepository;

import java.util.Collection;

@Service
public class UserAuthService {

  private final UserRepository userRepository;

  @Autowired
  public UserAuthService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public AuthUser checkUser(AuthUser login, AuthUser password) {
    userRepository.checkUser(user);
    return user;
  }

}
