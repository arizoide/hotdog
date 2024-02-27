package br.senac.familyhotdog.hotdog.controller;

import br.senac.familyhotdog.hotdog.dao.BoloRepository;
import br.senac.familyhotdog.hotdog.model.Bolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoloController {

    @Autowired
    private BoloRepository boloRepository;

    @GetMapping("/bolo")
    public String abrirCadBolo(Bolo bolo){
        return "cadastro_bolo";
    }

    @PostMapping("/bolo")
    public String salvarCadBolo(Bolo bolo){

        bolo.setNomeImagem("imagens/"+bolo.getNomeImagem()+".jpg");

        boloRepository.save(bolo);

        return "redirect:/";
    }

    @GetMapping("/editar-bolo/{id}")
    public String editBoloGet(@PathVariable Integer id, Model model){
        Bolo bolo = boloRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido " + id));

        model.addAttribute("bolo", bolo);

        return "update_bolo";
    }

    @PostMapping("/atualizar-bolo/{id}")
    public String editBoloPost(@PathVariable Integer id, Bolo bolo){
        boloRepository.save(bolo);

        return "redirect:/";
    }

    @GetMapping("/excluir-bolo/{id}")
    public String apagarBoloGet(@PathVariable Integer id){

        boloRepository.deleteById(id);

        return "redirect:/";
    }

}
