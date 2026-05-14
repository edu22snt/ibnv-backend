package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CELULA")
public class Celula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_CELULA")
    private Long id;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="NM_LIDER")
    private String lider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_ENDERECO")
    private Endereco endereco;

    @Column(name="NM_DIA_SEMANA")
    private String diaSemana;

    @Column(name="NM_HORARIO")
    private String horario;

    @Column(name="NM_ANFITRIAO")
    private String anfitriao;

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

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(String anfitriao) {
        this.anfitriao = anfitriao;
    }
}
