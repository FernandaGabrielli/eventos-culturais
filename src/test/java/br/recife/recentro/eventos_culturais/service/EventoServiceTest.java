package br.recife.recentro.eventos_culturais.service;

import br.recife.recentro.eventos_culturais.dto.EventoDto;
import br.recife.recentro.eventos_culturais.entity.Categoria;
import br.recife.recentro.eventos_culturais.entity.Evento;
import br.recife.recentro.eventos_culturais.exception.ResourceNotFoundException;
import br.recife.recentro.eventos_culturais.repository.EventoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EventoServiceTest {

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private EventoService eventoService;

    private Categoria categoria;
    private Evento evento;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        Categoria categoria = new Categoria("Musica");
        categoria.setId(1L); 
        evento = new Evento("Show", "Show de rock", "Recife", LocalDate.now().plusDays(1), categoria);
    }

    @Test
    void testSalvarEvento() {
        EventoDto dto = new EventoDto("Show", "Show de rock", "Recife", LocalDate.now().plusDays(1), 1L);

        when(categoriaService.buscarPorId(1L)).thenReturn(categoria);
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);

        Evento salvo = eventoService.salvar(dto);

        assertNotNull(salvo);
        assertEquals("Show", salvo.getNome());
        verify(eventoRepository, times(1)).save(any(Evento.class));
    }

    @Test
    void testAtualizarEventoNaoEncontrado() {
        when(eventoRepository.findById(1L)).thenReturn(Optional.empty());
        EventoDto dto = new EventoDto("Show", "Show atualizado", "Recife", LocalDate.now().plusDays(2), 1L);

        assertThrows(ResourceNotFoundException.class, () -> {
            eventoService.atualizar(1L, dto);
        });
    }
}
