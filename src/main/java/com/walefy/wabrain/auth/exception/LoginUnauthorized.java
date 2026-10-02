package com.walefy.wabrain.auth.exception;

import com.walefy.wabrain.shared.exception.HttpException;
import org.jboss.resteasy.reactive.RestResponse;

public class LoginUnauthorized extends HttpException {
  public LoginUnauthorized() {
    super("Email ou senha inválidos", RestResponse.Status.UNAUTHORIZED);
  }
}
