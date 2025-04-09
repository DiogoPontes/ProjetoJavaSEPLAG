package com.projeto.concurso.service;

import com.projeto.concurso.model.FotoPessoa;
import com.projeto.concurso.repository.FotoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoPessoaService {

    @Autowired
    private FotoPessoaRepository repository;

    public FotoPessoa salvar(FotoPessoa fotoPessoa) {
        return repository.save(fotoPessoa);
    }

    public List<FotoPessoa> listarTodos() {
        return repository.findAll();
    }

    public Optional<FotoPessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
