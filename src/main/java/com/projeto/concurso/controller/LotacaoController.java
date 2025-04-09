package com.projeto.concurso.controller;

import com.projeto.concurso.model.Lotacao;
import com.projeto.concurso.service.LotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotacoes")
public class LotacaoController {

    @Autowired
    private LotacaoService service;

    @PostMapping
    public ResponseEntity<Lotacao> criar(@RequestBody Lotacao lotacao) {
        return ResponseEntity.ok(service.salvar(lotacao));
    }

    @GetMapping
    public ResponseEntity<List<Lotacao>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lotacao> buscarPorId(@PathVariable Long id) {
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
	public ResponseEntity<Lotacao> atualizar(@PathVariable Long id, @RequestBody Lotacao lotacaoAtualizada) {
		return service.buscarPorId(id)
				.map(lotacaoExistente -> {
					lotacaoAtualizada.setId(id); // mantém o ID da entidade
					Lotacao atualizada = service.salvar(lotacaoAtualizada);
					return ResponseEntity.ok(atualizada);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
