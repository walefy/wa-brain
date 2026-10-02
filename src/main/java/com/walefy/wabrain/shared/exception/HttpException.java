package com.walefy.wabrain.shared.exception;

import org.jboss.resteasy.reactive.RestResponse;

public class HttpException extends RuntimeException {
  private final RestResponse.Status statusCode;

  public HttpException(String message, RestResponse.Status statusCode) {
    super(message);
    this.statusCode = statusCode;
  }

  public RestResponse.Status getStatusCode() {
    return statusCode;
  }
}
