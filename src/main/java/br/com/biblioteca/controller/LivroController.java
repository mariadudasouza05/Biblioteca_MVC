package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private static  List<Livro> listaLivros = new ArrayList<>();
    List livros = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", listaLivros);
        return "livros/inicio";
    }

    @PostMapping("/livros")
    public String cadastrar (@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("livros", livros);
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        listaLivros.add(livro);
        return "redirect:/livros";
    }
}