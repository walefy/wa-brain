package com.walefy.wabrain.auth;

import com.walefy.wabrain.auth.dto.JwtResponseDTO;
import com.walefy.wabrain.auth.dto.LoginDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/auth")
public class AuthController {
  @Inject AuthService authService;

  @POST
  public JwtResponseDTO login(@Valid LoginDTO loginDTO) {
    return authService.login(loginDTO);
  }
}
