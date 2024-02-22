package br.senac.familyhotdog.hotdog.controller;

import br.senac.familyhotdog.hotdog.dao.BoloRepository;
import br.senac.familyhotdog.hotdog.model.Bolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    BoloRepository boloRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Bolo> bolos = boloRepository.findAll();

        model.addAttribute("bolos", bolos);

        return "index";
    }
}
