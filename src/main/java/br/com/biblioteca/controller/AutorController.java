package br.com.biblioteca.controller;

import br.com.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private static final List<Autor> listaAutores = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", listaAutores);
        return "autores/inicio";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/salvar")
    public String salvarAutor(@ModelAttribute Autor autor) {
        listaAutores.add(autor);
        return "redirect:/autores";
    }
}