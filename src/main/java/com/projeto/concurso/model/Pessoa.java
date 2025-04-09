package com.projeto.concurso.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pes_sexo;
    private String pes_mae;
	private String pes_pai;
	private LocalDate dataNascimento;
	 
	 public LocalDate getDataNascimento() {
        return dataNascimento;
    }
	
	public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
