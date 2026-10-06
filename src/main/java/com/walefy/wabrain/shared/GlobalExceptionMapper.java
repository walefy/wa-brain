package com.walefy.wabrain.shared;

import com.walefy.wabrain.shared.exception.HttpException;
import io.quarkus.security.UnauthorizedException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionMapper {
  @ServerExceptionMapper
  public RestResponse<Map<String, Object>> handleHttpException(HttpException e) {
    String message = e.getMessage();
    RestResponse.Status statusCode = e.getStatusCode();

    Map<String, Object> response = new HashMap<>();
    response.put("message", message);
    response.put("status", statusCode.getStatusCode());

    return RestResponse.status(statusCode, response);
  }

  @ServerExceptionMapper
  public RestResponse<Map<String, Object>> handleUnauthorizedException(UnauthorizedException _e) {
    RestResponse.Status statusCode = RestResponse.Status.UNAUTHORIZED;

    Map<String, Object> response = new HashMap<>();
    response.put("message", "Você não está logado ou não tem acesso a este recurso");
    response.put("status", statusCode.getStatusCode());

    return RestResponse.status(statusCode, response);
  }

  @ServerExceptionMapper
  public RestResponse<Map<String, Object>> handleInternalServerError(Exception _e) {
    RestResponse.Status statusCode = RestResponse.Status.INTERNAL_SERVER_ERROR;
    Map<String, Object> response = new HashMap<>();
    response.put("message", "Erro interno no servidor");
    response.put("status", statusCode.getStatusCode());

    return RestResponse.status(statusCode, response);
  }
}
