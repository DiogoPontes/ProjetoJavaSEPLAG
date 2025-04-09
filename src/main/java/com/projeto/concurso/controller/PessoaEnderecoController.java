package com.projeto.concurso.controller;

import com.projeto.concurso.model.PessoaEndereco;
import com.projeto.concurso.service.PessoaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-enderecos")
public class PessoaEnderecoController {

    @Autowired
    private PessoaEnderecoService service;

    @PostMapping
    public ResponseEntity<PessoaEndereco> criar(@RequestBody PessoaEndereco pessoaEndereco) {
        return ResponseEntity.ok(service.salvar(pessoaEndereco));
    }

    @GetMapping
    public ResponseEntity<List<PessoaEndereco>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEndereco> buscarPorId(@PathVariable Long id) {
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
