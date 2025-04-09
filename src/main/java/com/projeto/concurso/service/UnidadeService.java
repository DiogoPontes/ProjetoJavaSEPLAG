package com.projeto.concurso.service;

import com.projeto.concurso.model.Unidade;
import com.projeto.concurso.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade salvar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public List<Unidade> listarTodos() {
        return unidadeRepository.findAll();
    }

    public Optional<Unidade> buscarPorId(Long id) {
        return unidadeRepository.findById(id);
    }

    public void deletar(Long id) {
        unidadeRepository.deleteById(id);
    }

    public void deletarTodos() {
        unidadeRepository.deleteAll();
    }
}
