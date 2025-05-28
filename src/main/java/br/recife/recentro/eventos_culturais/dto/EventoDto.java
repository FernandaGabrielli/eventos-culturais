package br.recife.recentro.eventos_culturais.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoDto(
    @NotBlank(message = "Nome é obrigatório") String nome,
    @NotBlank(message = "Descrição é obrigatória") String descricao,
    @NotBlank(message = "Local é obrigatório") String local,
    @NotNull(message = "Data é obrigatória")
    @FutureOrPresent(message = "Data deve ser hoje ou no futuro") LocalDate data,
    @NotNull(message = "ID da categoria é obrigatório") Long categoriaId
) {}
