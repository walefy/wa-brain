package com.walefy.wabrain.user.dto;

import com.walefy.wabrain.user.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class CreateUserDTO {
  @NotBlank(message = "Nome é obrigatório")
  @Size(min = 3, max = 10, message = "Nome deve ter entre 3 e 10 caracteres")
  public String firstName;

  @NotBlank(message = "Username é obrigatório")
  @Size(min = 3, max = 10, message = "Username deve ter entre 3 e 10 caracteres")
  public String username;

  @NotNull(message = "Data de nascimento é obrigatória")
  public Date birthDate;

  @NotBlank(message = "Senha é obrigatória")
  @Size(min = 8, max = 36, message = "Senha deve ter entre 8 e 36 caracteres")
  public String password;

  public UserEntity toEntity() {
    return new UserEntity(username, firstName, birthDate, password);
  }
}
