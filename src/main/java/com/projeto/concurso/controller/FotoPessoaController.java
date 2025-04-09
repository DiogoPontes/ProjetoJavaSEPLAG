package com.projeto.concurso.controller;

import com.projeto.concurso.model.FotoPessoa;
import com.projeto.concurso.service.FotoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoPessoaController {

    @Autowired
    private FotoPessoaService service;

    @PostMapping
    public ResponseEntity<FotoPessoa> criar(@RequestBody FotoPessoa fotoPessoa) {
        return ResponseEntity.ok(service.salvar(fotoPessoa));
    }

    @GetMapping
    public ResponseEntity<List<FotoPessoa>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoPessoa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
