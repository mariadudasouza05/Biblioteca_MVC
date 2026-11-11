package br.com.biblioteca.repository;

import br.com.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository
        extends JpaRepository<Autor, Long> {
}
