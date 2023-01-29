package com.example.newmysauna.domain.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newmysauna.domain.model.Sauna;

public interface SaunaRepository extends JpaRepository<Sauna, Long> {
}
