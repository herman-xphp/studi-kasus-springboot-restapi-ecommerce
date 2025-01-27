package com.muslimdev.ecommerce.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.muslimdev.ecommerce.entity.Pengguna;
import com.muslimdev.ecommerce.repository.PenggunaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private PenggunaRepository penggunaRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Pengguna pengguna = penggunaRepository.findById(username)
        .orElseThrow(() -> new UsernameNotFoundException("username " + username + " tidak ditemukan."));
    return UserDetailsImpl.build(pengguna);
  }

}
