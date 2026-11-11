package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        repository.save(livro);
        return "redirect:/livros";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/livros";
    }
}