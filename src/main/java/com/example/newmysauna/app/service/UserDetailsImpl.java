package com.example.newmysauna.app.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//ユーザー情報を保持し、DaoAuthenticationProviderクラスに提供
public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;
  private String userName;
  private String password;
  private Collection<GrantedAuthority> authorities;

  public UserDetailsImpl(String userName, String password, Collection<GrantedAuthority> authorities) {
    this.userName = userName;
    this.password = password;
    this.authorities = authorities;
  }

  @Override
  // 権限リストを返す
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  // パスワードを返す
  public String getPassword() {
    return password;
  }

  @Override
  // ユーザ名を返す
  public String getUsername() {
    return userName;
  }

  @Override
  // アカウントの有効期限の判定
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  // アカウントのロック状態の判定
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  // 資格情報の有効期限の判定
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  // 有効なユーザであるかの判定
  public boolean isEnabled() {
    return true;
  }
}
