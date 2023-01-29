package com.example.newmysauna.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newmysauna.domain.model.Sauna;
import com.example.newmysauna.domain.service.SaunaRepository;

@Service
public class SaunaService {
  @Autowired
  SaunaRepository saunaRepository;

  public List<Sauna> findAll() {
    return saunaRepository.findAll();
  }

  public void addSauna(Sauna sauna) {
    saunaRepository.save(sauna);
  }

  public Sauna findById(Long id) {
    Optional<Sauna> updateSauna = saunaRepository.findById(id);
    return updateSauna.get();
  }

  public void deleteById(Long id) {
    saunaRepository.deleteById(id);
  }

}
