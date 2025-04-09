package com.projeto.concurso.service;

import com.projeto.concurso.model.PessoaEndereco;
import com.projeto.concurso.repository.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaEnderecoService {

    @Autowired
    private PessoaEnderecoRepository repository;

    public PessoaEndereco salvar(PessoaEndereco pessoaEndereco) {
        return repository.save(pessoaEndereco);
    }

    public List<PessoaEndereco> listarTodos() {
        return repository.findAll();
    }

    public Optional<PessoaEndereco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
