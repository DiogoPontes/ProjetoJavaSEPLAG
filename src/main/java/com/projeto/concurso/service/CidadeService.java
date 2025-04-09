package com.projeto.concurso.service;

import com.projeto.concurso.model.Cidade;
import com.projeto.concurso.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void deletar(Long id) {
        cidadeRepository.deleteById(id);
    }

    public void deletarTodos() {
        cidadeRepository.deleteAll();
    }
}
