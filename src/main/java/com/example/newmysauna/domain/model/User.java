package com.example.newmysauna.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_name", nullable = false, length = 50)
  private String userName;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Sauna> saunas;

  // 空のコンストラクタ
  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<Sauna> getSaunas() {
    return saunas;
  }

  public void setSaunas(List<Sauna> saunas) {
    this.saunas = saunas;
  }
}
