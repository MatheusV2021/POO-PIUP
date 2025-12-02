package com.apiados.apiados.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String tipo; 
    private String nascimento;
    private String genero;
    private String deficiencia;
    private String cep;
    private String cidade;
    private String bairro;
    private String telefone;
}