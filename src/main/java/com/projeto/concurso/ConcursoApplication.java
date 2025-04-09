// src/main/java/com/projeto/concurso/ConcursoApplication.java
package com.projeto.concurso;

import com.projeto.concurso.model.Aluno;
import com.projeto.concurso.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConcursoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConcursoApplication.class, args);
    }
}






