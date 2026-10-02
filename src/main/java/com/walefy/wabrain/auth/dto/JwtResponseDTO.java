package com.walefy.wabrain.auth.dto;

public class JwtResponseDTO {
  public String token;

  public JwtResponseDTO(String token) {
    this.token = token;
  }
}
