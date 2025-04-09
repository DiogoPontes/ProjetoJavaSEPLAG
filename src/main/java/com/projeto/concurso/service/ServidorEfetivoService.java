package com.projeto.concurso.service;

import com.projeto.concurso.model.ServidorEfetivo;
import com.projeto.concurso.dto.ServidorEfetivoInfoDTO;

import java.util.List;
import java.util.Optional;

public interface ServidorEfetivoService {

    ServidorEfetivo salvar(ServidorEfetivo servidor);

    List<ServidorEfetivo> listarTodos();

    Optional<ServidorEfetivo> buscarPorId(Long id);

    void deletar(Long id);

    List<ServidorEfetivoInfoDTO> buscarPorUnidade(Long unidId);
}
