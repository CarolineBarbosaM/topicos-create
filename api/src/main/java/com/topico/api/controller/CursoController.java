package com.topico.api.controller;

import com.topico.api.curso.Curso;
import com.topico.api.curso.CursoRepository;
import com.topico.api.curso.DataCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataCurso dataCurso) {
        repository.save(new Curso(dataCurso));
    }

    @GetMapping
    public Page<Curso> list(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Curso> list(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody @Valid DataCurso dataCurso) {
        var curso = repository.getReferenceById(id);
        curso.atualizar(dataCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
