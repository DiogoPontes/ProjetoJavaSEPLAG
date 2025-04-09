package com.projeto.concurso.repository;

import com.projeto.concurso.model.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
}
