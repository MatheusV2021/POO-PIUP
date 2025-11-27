package com.apiados.apiados.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cidade;

    private String regiao;
}