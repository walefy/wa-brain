package com.walefy.wabrain.user.dto;

import com.walefy.wabrain.user.UserEntity;

import java.util.Date;
import java.util.UUID;

public class ReturnUserDTO {
  public UUID id;
  public String firstName;
  public Date birthDate;

  public ReturnUserDTO(UUID id, String firstName, Date birthDate) {
    this.id = id;
    this.firstName = firstName;
    this.birthDate = birthDate;
  }

  public static ReturnUserDTO fromEntity(UserEntity user) {
    return new ReturnUserDTO(user.getId(), user.getFirstName(), user.getBirthDate());
  }
}
