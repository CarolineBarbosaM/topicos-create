package com.topico.api.controller;

import com.topico.api.autor.Autor;
import com.topico.api.autor.AutorRepository;
import com.topico.api.autor.DataAutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DataAutor dataAutor) {
        repository.save(new Autor(dataAutor));
    }

    @GetMapping
    public Page<Autor> list(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Autor> list(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody @Valid DataAutor dataAutor) {
        var curso = repository.getReferenceById(id);
        curso.atualizar(dataAutor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
