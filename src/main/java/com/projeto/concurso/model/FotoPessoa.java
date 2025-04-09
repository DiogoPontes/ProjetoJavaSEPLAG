package com.projeto.concurso.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FotoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fp_data;

    private String fp_bucket;

    private String fp_hash; // Ex: URL gerada pelo MinIO
	
	public String getFp_hash() {
        return fp_hash;
    }
	
	public void setFp_hash(String fp_hash) {
        this.fp_hash = fp_hash;
    }

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
