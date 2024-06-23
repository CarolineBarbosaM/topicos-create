package com.topico.api.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;

    public Curso(DataCurso dataCurso) {
        this.nome = dataCurso.nome();
        this.categoria = dataCurso.categoria();
    }

    public void atualizar(DataCurso dataCurso) {
        if (dataCurso.nome() != null) {
            this.nome = dataCurso.nome();
        }

        if (dataCurso.categoria() != null) {
            this.categoria = dataCurso.categoria();
        }
    }

    public void deletar(DataCurso dataCurso) {
    }
}
