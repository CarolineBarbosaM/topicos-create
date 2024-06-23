package com.topico.api.autor;

import jakarta.validation.constraints.NotBlank;

public record DataAutor(
        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String senha
) {}
