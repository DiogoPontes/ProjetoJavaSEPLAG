package com.projeto.concurso.dto;

public class ServidorEfetivoInfoDTO {
    private String nome;
    private int idade;
    private String unidade;
    private String foto;

    public ServidorEfetivoInfoDTO(String nome, int idade, String unidade, String foto) {
        this.nome = nome;
        this.idade = idade;
        this.unidade = unidade;
        this.foto = foto;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
}
