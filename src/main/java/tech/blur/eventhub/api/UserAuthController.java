package tech.blur.eventhub.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.blur.eventhub.models.AuthUser;
import tech.blur.eventhub.models.User;
import tech.blur.eventhub.services.UserAuthService;
import tech.blur.eventhub.services.UserService;

import java.util.Collection;

@RestController
public class UserAuthController {

  private static final String USERS_PATH = Resources.API_PREFIX + "auth";

  @Autowired
  private UserAuthService service;

  // @PostMapping(USERS_PATH)
  // public @ResponseBody
  // BaseResponse<User> checkUser(@RequestBody AuthUser user) {
  //   BaseResponse<User> response = new BaseResponse<>();
  //   User result = service.createUser(user);
  //   response.setData(result);
  //   return response;
  // }

}