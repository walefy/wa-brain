package com.walefy.wabrain.user.exception;

import com.walefy.wabrain.shared.exception.HttpException;
import org.jboss.resteasy.reactive.RestResponse;

public class UserNotFound extends HttpException {
  public UserNotFound() {
    super("Usuário não encontrado", RestResponse.Status.NOT_FOUND);
  }
}
