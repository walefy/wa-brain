package com.walefy.wabrain.user;

import com.walefy.wabrain.user.dto.CreateUserDTO;
import com.walefy.wabrain.user.dto.GetUsersQueryDTO;
import com.walefy.wabrain.user.dto.ReturnUserDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/user")
public class UserController {
  @Inject private UserService userService;

  @POST
  public ReturnUserDTO createUser(@Valid CreateUserDTO createUserData) {
    return userService.createUser(createUserData);
  }

  @GET
  public List<ReturnUserDTO> findAllUsers(@Valid @BeanParam GetUsersQueryDTO query) {
    return userService.getUsers(query);
  }
}
