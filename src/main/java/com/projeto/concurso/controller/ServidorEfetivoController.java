package com.projeto.concurso.controller;

import com.projeto.concurso.model.ServidorEfetivo;
import com.projeto.concurso.service.ServidorEfetivoService;
import com.projeto.concurso.dto.ServidorEfetivoInfoDTO; // <- este é o que faltava

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores-efetivos")
public class ServidorEfetivoController {

    @Autowired
    private ServidorEfetivoService service;

    @PostMapping
    public ResponseEntity<ServidorEfetivo> criar(@RequestBody ServidorEfetivo servidor) {
        return ResponseEntity.ok(service.salvar(servidor));
    }

    @GetMapping
    public ResponseEntity<List<ServidorEfetivo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorEfetivo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorEfetivo> atualizar(@PathVariable Long id, @RequestBody ServidorEfetivo servidorAtualizado) {
        return service.buscarPorId(id)
                .map(servidorExistente -> {
                    servidorAtualizado.setId(id);
                    ServidorEfetivo atualizado = service.salvar(servidorAtualizado);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/unidade/{unid_id}")
    public ResponseEntity<List<ServidorEfetivoInfoDTO>> listarPorUnidade(@PathVariable("unid_id") Long unidadeId) {
        return ResponseEntity.ok(service.buscarPorUnidade(unidadeId));
    }
}
