package com.projeto.concurso.service;

import com.projeto.concurso.model.UnidadeEndereco;
import com.projeto.concurso.repository.UnidadeEnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeEnderecoService {

    private final UnidadeEnderecoRepository repository;

    public UnidadeEnderecoService(UnidadeEnderecoRepository repository) {
        this.repository = repository;
    }

    public UnidadeEndereco salvar(UnidadeEndereco unidadeEndereco) {
        return repository.save(unidadeEndereco);
    }

    public List<UnidadeEndereco> listarTodos() {
        return repository.findAll();
    }

    public UnidadeEndereco buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
