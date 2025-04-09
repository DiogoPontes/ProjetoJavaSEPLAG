package com.projeto.concurso.controller;

import com.projeto.concurso.model.UnidadeEndereco;
import com.projeto.concurso.service.UnidadeEnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade-enderecos")
public class UnidadeEnderecoController {

    private final UnidadeEnderecoService service;

    public UnidadeEnderecoController(UnidadeEnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UnidadeEndereco> criar(@RequestBody UnidadeEndereco unidadeEndereco) {
        return ResponseEntity.ok(service.salvar(unidadeEndereco));
    }

    @GetMapping
    public ResponseEntity<List<UnidadeEndereco>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeEndereco> buscar(@PathVariable Long id) {
        UnidadeEndereco ue = service.buscarPorId(id);
        return ue != null ? ResponseEntity.ok(ue) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
