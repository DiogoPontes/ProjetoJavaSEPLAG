package com.projeto.concurso.repository;

import com.projeto.concurso.model.FotoPessoa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoPessoaRepository extends JpaRepository<FotoPessoa, Long> {

	public List<FotoPessoa> findByPessoaId(Long pessoaId);


}
