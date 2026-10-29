package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        List<Livro> livros = List.of(
                new Livro("Dom Casmurro", "Machado de Assis", "978-85-00-00000-1", 1899),
                new Livro("O Alquimista", "Paulo Coelho", "978-85-00-00000-2", 1988),
                new Livro("Grande Sertão: Veredas", "João Guimarães Rosa", "978-85-00-00000-3", 1956)
        );

        model.addAttribute("mensagem", "Bem-vindo ao Sistema da Biblioteca!");
        model.addAttribute("livros", livros);

        return "index";
    }
}