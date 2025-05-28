package br.recife.recentro.eventos_culturais.controller;

import br.recife.recentro.eventos_culturais.dto.EventoDto;
import br.recife.recentro.eventos_culturais.entity.Evento;
import br.recife.recentro.eventos_culturais.service.EventoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private static final Logger logger = LoggerFactory.getLogger(EventoController.class);

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento criar(@RequestBody @Valid EventoDto dto) {
        logger.info("Recebendo requisição para criar evento: {}", dto.nome());
        return service.salvar(dto);
    }

    @GetMapping
    public List<Evento> listarTodos() {
        logger.info("Recebendo requisição para listar todos os eventos");
        return service.listarTodos();
    }

    @GetMapping("/tipo/{tipo}")
    public List<Evento> listarPorTipo(@PathVariable String tipo) {
        logger.info("Recebendo requisição para listar eventos por tipo: {}", tipo);
        return service.listarPorTipo(tipo);
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody @Valid EventoDto dto) {
        logger.info("Recebendo requisição para atualizar evento id: {}", id);
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        logger.info("Recebendo requisição para deletar evento id: {}", id);
        service.deletar(id);
    }
}
