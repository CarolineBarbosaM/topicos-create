package com.topico.api.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCurso(
        @NotBlank
        String nome,

        @NotBlank
        String categoria
) {}
