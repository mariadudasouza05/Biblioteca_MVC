package br.com.biblioteca.controller;

import br.com.biblioteca.model.Autor;
import br.com.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", repository.findAll());
        return "autores/inicio";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/salvar")
    public String salvarAutor(@ModelAttribute Autor autor) {
        repository.save(autor);
        return "redirect:/autores";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/autores";
    }
}