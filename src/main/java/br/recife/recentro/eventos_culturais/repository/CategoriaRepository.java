package br.recife.recentro.eventos_culturais.repository;

import br.recife.recentro.eventos_culturais.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
