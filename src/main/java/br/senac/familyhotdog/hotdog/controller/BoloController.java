package br.senac.familyhotdog.hotdog.controller;

import br.senac.familyhotdog.hotdog.dao.BoloRepository;
import br.senac.familyhotdog.hotdog.model.Bolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bolo")
public class BoloController {

    @Autowired
    private BoloRepository boloRepository;

    @GetMapping
    public String abrirCadBolo(Bolo bolo){
        return "cadastro_bolo";
    }

    @PostMapping
    public String salvarCadBolo(Bolo bolo){

        bolo.setNomeImagem("imagens/"+bolo.getNomeImagem()+".jpg");

        boloRepository.save(bolo);

        return "redirect:/";
    }

}
