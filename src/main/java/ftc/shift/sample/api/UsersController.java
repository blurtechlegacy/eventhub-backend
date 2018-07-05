package ftc.shift.sample.api;


import ftc.shift.sample.models.User;
import ftc.shift.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UsersController {

  private static final String USERS_PATH = Resources.API_PREFIX + "users";

  @Autowired
  private UserService service;

  @GetMapping(USERS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<User> readUser(@PathVariable String id) {
    BaseResponse<User> response = new BaseResponse<>();
    User user = service.provideUser(id);

    if (null == user) {
      response.setStatus("USER_NOT_EXIST");  //для статусов  можно сделать отдельные Enum-ы или вынести как строковые константы
      response.setMessage("User not found!");
    } else {
      response.setData(user);
    }
    return response;
  }

  @GetMapping(USERS_PATH)
  public @ResponseBody
  BaseResponse<Collection<User>> listUsers() {
    BaseResponse<Collection<User>> response = new BaseResponse<>();
    Collection<User> result = service.provideUsers();
    response.setData(result);
    return response;
  }

  @PostMapping(USERS_PATH)
  public @ResponseBody
  BaseResponse<User> createUser(@RequestBody User user) {
    BaseResponse<User> response = new BaseResponse<>();
    User result = service.createUser(user);
    response.setData(result);
    return response;
  }

  @DeleteMapping(USERS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse deleteUser(@PathVariable String id) {
    service.deleteUser(id);
    return new BaseResponse(); //нет тела, только статус
  }

  @PatchMapping(USERS_PATH + "/{id}")
  public @ResponseBody
  BaseResponse<User> updateUser(@PathVariable String id, @RequestBody User user) {
    BaseResponse<User> response = new BaseResponse<>();
    User result = service.updateUser(user);
    response.setData(result);
    return response;
  }

}