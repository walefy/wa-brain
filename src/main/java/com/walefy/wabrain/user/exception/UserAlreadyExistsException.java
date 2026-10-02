package com.walefy.wabrain.user.exception;

import com.walefy.wabrain.shared.exception.HttpException;
import org.jboss.resteasy.reactive.RestResponse;

public class UserAlreadyExistsException extends HttpException {
  public UserAlreadyExistsException() {
    super("Este username já está em uso", RestResponse.Status.CONFLICT);
  }
}
