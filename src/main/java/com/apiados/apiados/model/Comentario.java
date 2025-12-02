package com.apiados.apiados.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    public Comentario() {
    }

    public Comentario(Long id, String autor, String mensagem) {
        this.id = id;
        this.autor = autor;
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
