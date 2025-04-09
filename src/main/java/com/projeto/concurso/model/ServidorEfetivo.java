package com.projeto.concurso.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServidorEfetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa; 
   
}
