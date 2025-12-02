package com.apiados.apiados.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MoradiaVulneravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;

    private String responsavelNome;

    private String responsavelContato;

    // Checklist simplificado
    private Boolean riscoEstrutural;
    private Boolean saneamentoPrecario;
    private Boolean acessibilidadeRuim;
    private Boolean riscoAlagamento;

    private Double indicePrioridade;

    private String status;

    @ManyToOne
    @JoinColumn(name = "bairro_id")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "agente_id")
    private Usuario agente;
}
