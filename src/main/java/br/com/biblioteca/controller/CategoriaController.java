package br.com.biblioteca.controller;

import br.com.biblioteca.model.Categoria;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.repository.CategoriaRepository;
import br.com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categorias", repository.findAll());
        return "categorias/inicio";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping("/salvar")
    public String salvarCategoria(@ModelAttribute Categoria categoria) {
        repository.save(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/categorias";
    }
}
