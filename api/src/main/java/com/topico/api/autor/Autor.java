package com.topico.api.autor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Autor(DataAutor dataAutor) {
        this.nome = dataAutor.nome();
        this.email = dataAutor.email();
        this.senha = dataAutor.senha();
    }

    public void atualizar(DataAutor dataAutor) {
        if (dataAutor.nome() != null) {
            this.nome = dataAutor.nome();
        }

        if (dataAutor.email() != null) {
            this.email = dataAutor.email();
        }

        if (dataAutor.senha() != null) {
            this.senha = dataAutor.senha();
        }
    }
}
