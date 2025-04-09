package com.projeto.concurso.service;

import com.projeto.concurso.model.Lotacao;
import com.projeto.concurso.repository.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotacaoService {

    @Autowired
    private LotacaoRepository repository;

    public Lotacao salvar(Lotacao lotacao) {
        return repository.save(lotacao);
    }

    public List<Lotacao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Lotacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
