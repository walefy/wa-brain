package com.walefy.wabrain.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
  @NotBlank(message = "Username é obrigatório")
  public String username;

  @NotBlank(message = "Password é obrigatória")
  public String password;
}
