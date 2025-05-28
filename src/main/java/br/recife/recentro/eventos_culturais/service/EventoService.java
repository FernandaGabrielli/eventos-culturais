package br.recife.recentro.eventos_culturais.service;

import br.recife.recentro.eventos_culturais.dto.EventoDto;
import br.recife.recentro.eventos_culturais.entity.Categoria;
import br.recife.recentro.eventos_culturais.entity.Evento;
import br.recife.recentro.eventos_culturais.exception.ResourceNotFoundException;
import br.recife.recentro.eventos_culturais.repository.EventoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private static final Logger logger = LoggerFactory.getLogger(EventoService.class);

    private final EventoRepository eventoRepository;
    private final CategoriaService categoriaService;

    public EventoService(EventoRepository eventoRepository, CategoriaService categoriaService) {
        this.eventoRepository = eventoRepository;
        this.categoriaService = categoriaService;
    }

    public Evento salvar(EventoDto dto) {
        logger.info("Salvando evento: {}", dto.nome());
        Categoria categoria = categoriaService.buscarPorId(dto.categoriaId());
        Evento evento = new Evento(
            dto.nome(),
            dto.descricao(),
            dto.local(),
            dto.data(),
            categoria
        );
        return eventoRepository.save(evento);
    }

    public List<Evento> listarTodos() {
        logger.info("Listando todos os eventos");
        return eventoRepository.findAll();
    }

    public List<Evento> listarPorTipo(String tipo) {
        logger.info("Listando eventos do tipo: {}", tipo);
        return eventoRepository.findByCategoriaNomeIgnoreCase(tipo);
    }

    public Evento atualizar(Long id, EventoDto dto) {
        logger.info("Atualizando evento com id: {}", id);
        Evento eventoExistente = eventoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));

        Categoria categoria = categoriaService.buscarPorId(dto.categoriaId());

        eventoExistente.setNome(dto.nome());
        eventoExistente.setDescricao(dto.descricao());
        eventoExistente.setLocal(dto.local());
        eventoExistente.setData(dto.data());
        eventoExistente.setCategoria(categoria);

        return eventoRepository.save(eventoExistente);
    }

    public void deletar(Long id) {
        logger.info("Deletando evento com id: {}", id);
        Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));
        eventoRepository.delete(evento);
    }

    public Evento buscarPorId(Long id) {
        logger.info("Buscando evento com id: {}", id);
        return eventoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id " + id));
    }
}
