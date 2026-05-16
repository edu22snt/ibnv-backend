package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_CIDADE")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CIDADE")
    private Long id;

    @Column(name = "NM_CIDADE", nullable = false, length = 150)
    private String nome;

    @Column(name = "DS_CODIGO_IBGE", length = 20)
    private String codigoIbge;

    @Column(name = "NR_CEP", length = 10)
    private String cep;

    @Column(name = "NR_POPULACAO")
    private Long populacao;

    @Column(name = "ST_CAPITAL")
    private Boolean capital = false;

    @Column(name = "ST_ATIVO")
    private Boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_ESTADO", nullable = false)
    private Estado estado;

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

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}