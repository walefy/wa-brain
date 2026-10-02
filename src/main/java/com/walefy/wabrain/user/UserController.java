package com.walefy.wabrain.user;

import com.walefy.wabrain.user.dto.CreateUserDTO;
import com.walefy.wabrain.user.dto.GetUsersQueryDTO;
import com.walefy.wabrain.user.dto.ReturnUserDTO;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;

@Path("/user")
@Authenticated
public class UserController {
  @Inject private UserService userService;
  @Inject private JsonWebToken jwt;

  @POST
  @PermitAll
  public ReturnUserDTO createUser(@Valid CreateUserDTO createUserData) {
    return userService.createUser(createUserData);
  }

  @GET
  public List<ReturnUserDTO> getUsers(@Valid @BeanParam GetUsersQueryDTO query) {
    return userService.getUsers(query);
  }

  @DELETE
  public void deleteUser() {
    String username = jwt.getSubject();
    userService.deleteUser(username);
  }
}
