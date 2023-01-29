package com.example.newmysauna.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.newmysauna.app.service.SaunaService;
import com.example.newmysauna.domain.model.Sauna;

@Controller
public class SaunaController {
  @Autowired
  SaunaService saunaService;

  // 一覧ページ表示
  @GetMapping("/sauna")
  public String index(@ModelAttribute Sauna sauna, Model model) {
    List<Sauna> saunaList = saunaService.findAll();
    model.addAttribute("saunalist", saunaList);
    return "sauna/index";
  }

  // 登録画面表示
  @GetMapping("/sauna/new")
  public String desplayAdd(Sauna sauna) {
    return "sauna/new";
  }

  // 登録する
  @PostMapping("/sauna/create")
  public String create(@Validated @ModelAttribute Sauna sauna, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("allSauna", saunaService.findAll());
      return "sauna/new";
    }
    saunaService.addSauna(sauna);
    return "redirect:/sauna";
  }

  // 編集画面
  @GetMapping("/sauna/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("post", saunaService.findById(id));
    return "sauna/edit";
  }

  // 更新
  public String update(@PathVariable Long id, Sauna sauna, BindingResult result) {
    if (result.hasErrors()) {
      return "sauna/edit";
    }
    saunaService.addSauna(sauna);
    return "redirect:/sauna";
  }

  // 削除する
  @PostMapping("/sauna/delete/{id}")
  public String delete(@PathVariable Long id) {
    saunaService.deleteById(id);
    return "redirect:/sauna";
  }
}
