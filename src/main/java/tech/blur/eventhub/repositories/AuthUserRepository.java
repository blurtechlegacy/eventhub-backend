package tech.blur.eventhub.repositories;

import tech.blur.eventhub.models.AuthUser;
import tech.blur.eventhub.models.User;

import java.util.Collection;

public interface AuthUserRepository {

  AuthUser checkUser(AuthUser login, AuthUser password);
}