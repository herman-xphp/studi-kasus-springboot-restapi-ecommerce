package com.muslimdev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.ecommerce.entity.Pengguna;
import com.muslimdev.ecommerce.model.JwtResponse;
import com.muslimdev.ecommerce.model.LoginRequest;
import com.muslimdev.ecommerce.model.SignUpRequest;
import com.muslimdev.ecommerce.security.jwt.JwtUtils;
import com.muslimdev.ecommerce.security.service.UserDetailsImpl;
import com.muslimdev.ecommerce.service.PenggunaService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PenggunaService penggunaService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest request) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
    return ResponseEntity.ok().body(new JwtResponse(token, principal.getUsername(), principal.getEmail()));
  }

  @PostMapping("/signup")
  public Pengguna signup(@RequestBody SignUpRequest request) {
    Pengguna pengguna = new Pengguna();
    pengguna.setId(request.getUsername());
    pengguna.setEmail(request.getEmail());
    pengguna.setNama(request.getNama());
    pengguna.setPassword(passwordEncoder.encode(request.getPassword())); // Encrypt password
    pengguna.setRoles("user");
    Pengguna created = penggunaService.create(pengguna);
    return created;
  }
}
