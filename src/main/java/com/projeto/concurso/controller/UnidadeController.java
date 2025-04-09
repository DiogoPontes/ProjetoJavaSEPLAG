package com.projeto.concurso.controller;

import com.projeto.concurso.model.Unidade;
import com.projeto.concurso.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<Unidade> criar(@RequestBody Unidade unidade) {
        return ResponseEntity.ok(unidadeService.salvar(unidade));
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> listar() {
        return ResponseEntity.ok(unidadeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscar(@PathVariable Long id) {
        return unidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTodos() {
        unidadeService.deletarTodos();
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Unidade> atualizar(@PathVariable Long id, @RequestBody Unidade unidadeAtualizada) {
		return unidadeService.buscarPorId(id)
				.map(unidadeExistente -> {
					unidadeAtualizada.setId(id); // garante que o ID se mantenha
					Unidade atualizada = unidadeService.salvar(unidadeAtualizada);
					return ResponseEntity.ok(atualizada);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
