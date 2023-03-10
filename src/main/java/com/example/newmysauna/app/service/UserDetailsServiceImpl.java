package com.example.newmysauna.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//DaoAuthenticationProviderクラスからの依頼で、DBからユーザ情報を取得する役割を担う
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    try {
      String sql = "SELECT * FROM user WHERE name = ?";
      Map<String, Object> map = jdbcTemplate.queryForMap(sql, userName);
      String password = (String) map.get("password");
      Collection<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority((String) map.get("authority")));
      return new UserDetailsImpl(userName, password, authorities);
    } catch (Exception e) {
      throw new UsernameNotFoundException("user not found.", e);
    }
  }
}
