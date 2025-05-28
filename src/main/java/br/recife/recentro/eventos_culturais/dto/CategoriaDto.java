package br.recife.recentro.eventos_culturais.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDto(
    @NotBlank(message = "Nome da categoria é obrigatório")
    String nome
) {}
