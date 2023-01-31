package com.example.newmysauna.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDeatailsService {
  // ユーザ名からユーザ情報を取得
  UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
