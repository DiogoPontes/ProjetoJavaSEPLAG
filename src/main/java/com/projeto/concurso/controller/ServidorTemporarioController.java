package com.projeto.concurso.controller;

import com.projeto.concurso.model.ServidorTemporario;
import com.projeto.concurso.service.ServidorTemporarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores-temporarios")
public class ServidorTemporarioController {

    @Autowired
    private ServidorTemporarioService service;

    @PostMapping
    public ResponseEntity<ServidorTemporario> criar(@RequestBody ServidorTemporario servidor) {
        return ResponseEntity.ok(service.salvar(servidor));
    }

    @GetMapping
    public ResponseEntity<List<ServidorTemporario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorTemporario> buscarPorId(@PathVariable Long id) {
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
	public ResponseEntity<ServidorTemporario> atualizar(@PathVariable Long id, @RequestBody ServidorTemporario servidorAtualizado) {
		return service.buscarPorId(id)
				.map(servidorExistente -> {
					servidorAtualizado.setId(id); // garante que o ID não será alterado
					ServidorTemporario atualizado = service.salvar(servidorAtualizado);
					return ResponseEntity.ok(atualizado);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
