package com.muslimdev.ecommerce.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muslimdev.ecommerce.entity.Pengguna;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

  private String username;
  @JsonIgnore
  private String password;
  private String nama;
  private String email;
  @JsonIgnore
  private String roles;

  public UserDetailsImpl(String username, String password, String nama, String email, String roles) {
    this.username = username;
    this.password = password;
    this.nama = nama;
    this.email = email;
    this.roles = roles;
  }

  public static UserDetailsImpl build(Pengguna pengguna) {
    return new UserDetailsImpl(pengguna.getId(), pengguna.getPassword(), pengguna.getNama(), pengguna.getEmail(),
        pengguna.getRoles());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (StringUtils.hasText(roles)) {
      String[] splits = roles.replaceAll(" ", "").split(",");
      for (String split : splits) {
        authorities.add(new SimpleGrantedAuthority(split));
      }
    }
    return authorities;
  }
}
