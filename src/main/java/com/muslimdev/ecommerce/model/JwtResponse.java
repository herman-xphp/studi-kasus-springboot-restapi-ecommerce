package com.muslimdev.ecommerce.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {
  private String token;
  private String type = "Bearer";
  private String username;
  private String email;

  public JwtResponse(String accessToken, String username, String email) {
    this.token = accessToken;
    this.username = username;
    this.email = email;
  }

}
