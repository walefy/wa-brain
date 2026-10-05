package com.walefy.wabrain.user.dto;

import com.walefy.wabrain.user.UserEntity;

import java.util.Date;
import java.util.UUID;

public class ReturnUserDTO {
  public UUID id;
  public String firstName;
  public Date birthDate;

  public ReturnUserDTO(UserEntity user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.birthDate = user.getBirthDate();
  }
}
