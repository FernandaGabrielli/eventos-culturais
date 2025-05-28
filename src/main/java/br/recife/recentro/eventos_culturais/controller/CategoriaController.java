package br.recife.recentro.eventos_culturais.controller;

import br.recife.recentro.eventos_culturais.dto.CategoriaDto;
import br.recife.recentro.eventos_culturais.entity.Categoria;
import br.recife.recentro.eventos_culturais.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criar(@RequestBody @Valid CategoriaDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<Categoria> listarTodas() {
        return service.listarTodas();
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
