package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_MINISTERIO")
public class Ministerio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_MINISTERIO")
    private Long id;

    @Column(name="NM_NOME")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_MEMBRO")
    private Membro lider;

    @Column(name="NM_TIPO")
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
