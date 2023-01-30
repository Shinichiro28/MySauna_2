package com.example.newmysauna.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Sauna {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /*
   * @ManyToOne
   * 
   * @JoinColumn(name = "user_id")
   * private User user;
   */
  @Column(name = "sauna_name", nullable = false, length = 20)
  private String saunaName;

  @Column(name = "sauna_temp", nullable = false, length = 3)
  private Integer saunaTemp;

  @Column(name = "sauna_time", nullable = true, length = 2)
  private Integer saunaTime;

  @Column(name = "sauna_satis", nullable = false, length = 3)
  private Integer saunaSatis;

  @Column(name = "water_temp", nullable = false, length = 3)
  private Integer waterTemp;

  @Column(name = "water_time", nullable = true, length = 2)
  private Integer waterTime;

  @Column(name = "water_satis", nullable = false, length = 3)
  private Integer waterSatis;

  // 空のコンストラクタ
  public Sauna() {
  }

}
