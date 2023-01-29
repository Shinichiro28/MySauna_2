package com.example.newmysauna.domain.service;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SaunaAddRequest implements Serializable {

  @NotEmpty(message = "施設名を入れて下さい")
  public String sauna_name;

  @NotNull(message = "サウナ室の温度を入力して下さい")
  public Integer sauna_temp;

  public Integer sauna_time;

  @NotNull(message = "サウナの満足度を入力して下さい")
  public Integer sauna_satis;

  @NotNull(message = "水風呂の温度を入力して下さい")
  public Integer water_temp;

  public Integer water_time;

  @NotNull(message = "水風呂の満足度を入力して下さい")
  public Integer water_satis;
}
