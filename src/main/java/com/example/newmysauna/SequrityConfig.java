package com.example.newmysauna;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SequrityConfig extends WebSecurityConfigurerAdapter {

  // ハッシュ化
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // CSSフォルダのファイルはSpringSecurityの処理を適用しない
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**");
  }

  // ユーザ名をパスワードを指定
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("sauna3")
        .password(passwordEncoder().encode("123456"))
        .roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .authenticated();
    // ログイン機能を有効
    http.formLogin()
        .loginPage("/user/login")
        .defaultSuccessUrl("/sauna")
        .permitAll();
    // ログアウト機能を有効
    http.logout()
        .permitAll();
  }
}
