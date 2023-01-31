package com.example.newmysauna.domain.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails extends Serializable {
  // 権限リストを返す
  Collection<? extends GrantedAuthority> getAuthorities();

  // パスワードを返す
  String getPassword();

  // ユーザ名を返す
  String getUsername();

  // アカウントの有効期限の判定
  boolean isAccountNonExpired();

  // アカウントロック状態の判定
  boolean isAccountNonLocked();

  // 資格情報の有効期限の判定
  boolean isCredentialsNonExpired();

  // 有効なユーザであるかの判定
  boolean isEnabled();
}
