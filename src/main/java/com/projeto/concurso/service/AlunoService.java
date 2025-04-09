package com.projeto.concurso.service;

import com.projeto.concurso.model.Aluno;
import com.projeto.concurso.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodas() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno criar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        if (alunoRepository.existsById(id)) {
            alunoAtualizado.setId(id);
            return alunoRepository.save(alunoAtualizado);
        } else {
            throw new RuntimeException("Aluno não encontrado");
        }
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}
