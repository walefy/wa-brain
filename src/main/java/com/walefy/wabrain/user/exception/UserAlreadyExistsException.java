package com.walefy.wabrain.user.exception;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException() {
    super("Este nome de usuário já está em uso");
  }
}
