package br.recife.recentro.eventos_culturais.service;

import br.recife.recentro.eventos_culturais.dto.CategoriaDto;
import br.recife.recentro.eventos_culturais.entity.Categoria;
import br.recife.recentro.eventos_culturais.exception.ResourceNotFoundException;
import br.recife.recentro.eventos_culturais.repository.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria criar(CategoriaDto dto) {
        repository.findByNome(dto.nome()).ifPresent(c -> {
            throw new IllegalArgumentException("Categoria já existe com esse nome");
        });
        Categoria categoria = new Categoria(dto.nome());
        Categoria salva = repository.save(categoria);
        logger.info("Categoria criada: {}", salva.getNome());
        return salva;
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada: " + id));
    }

    public Categoria atualizar(Long id, CategoriaDto dto) {
        Categoria categoria = buscarPorId(id);
        categoria.setNome(dto.nome());
        Categoria salva = repository.save(categoria);
        logger.info("Categoria atualizada: {}", salva.getNome());
        return salva;
    }

    public void deletar(Long id) {
        buscarPorId(id); // valida se existe
        repository.deleteById(id);
        logger.info("Categoria deletada: {}", id);
    }
}
