package com.walefy.wabrain.user.dto;

import com.walefy.wabrain.user.UserEntity;

import java.util.Date;
import java.util.UUID;

public record ReturnUserDTO(UUID id, String firstName, Date birthDate) {
  public static ReturnUserDTO fromEntity(UserEntity user) {
    return new ReturnUserDTO(user.getId(), user.getFirstName(), user.getBirthDate());
  }
}
