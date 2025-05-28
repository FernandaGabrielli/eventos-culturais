package br.recife.recentro.eventos_culturais.repository;

import br.recife.recentro.eventos_culturais.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByTipo(String tipo);
    List<Evento> findByCategoriaNomeIgnoreCase(String nome);

}
