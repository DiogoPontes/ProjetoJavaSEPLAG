package com.projeto.concurso.repository;

import com.projeto.concurso.model.Lotacao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {

    List<Lotacao> findByPessoaId(Long pessoaId);

    boolean existsByPessoaIdAndUnidadeId(Long pessoaId, Long unidadeId);
}
