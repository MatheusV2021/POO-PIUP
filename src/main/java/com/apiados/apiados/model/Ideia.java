package com.apiados.apiados.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ideia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String categoria;
    private String status;
    private String foto;
    private String localizacao;
    private Integer prioridade;

    @ManyToOne
    private Usuario usuario;
}
