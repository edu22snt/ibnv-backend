package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_FINANCEIRO")
public class Financeiro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_FINANCEIRO")
    private Long id;

    @Column(name="NM_TIPO")
    private String tipo;

    @Column(name="NM_CATEGORIA")
    private String categoria;

    @Column(name = "NU_VALOR", precision = 15, scale = 2)
    private BigDecimal valor;

    @Column(name="DT_DATA")
    private LocalDateTime data;

    @Column(name="NM_DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="CD_MEMBRO")
    private Membro membro;
}
