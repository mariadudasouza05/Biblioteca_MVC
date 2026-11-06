package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;
    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    private static  List<Livro> listaLivros = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", listaLivros);
        return "livros/inicio";
    }

    @PostMapping("/livros")
    public String cadastrar (@ModelAttribute Livro livro){
        repository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        List<Livro> livros = repository.findAll();
        model.addAttribute("livros", livros);
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        listaLivros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping ("/excluir/{indice}")
    public String excluir (@PathVariable int indice) {
        listaLivros.remove(indice);
        return "redirect:/livros";
    }
}