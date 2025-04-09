package com.projeto.concurso.service;

import com.projeto.concurso.model.ServidorTemporario;
import com.projeto.concurso.repository.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorTemporarioService {

    @Autowired
    private ServidorTemporarioRepository repository;

    public ServidorTemporario salvar(ServidorTemporario servidor) {
        return repository.save(servidor);
    }

    public List<ServidorTemporario> listarTodos() {
        return repository.findAll();
    }

    public Optional<ServidorTemporario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
