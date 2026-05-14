package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_EVENTO_PARTICIPANTES")
public class EventoParticipantes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_EVENTO_PARTICIPANTES")
    private Long id;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="NM_EMAIL")
    private String email;

    @Column(name="NM_TELEFONE")
    private String numTelefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_EVENTO")
    private Evento evento;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
