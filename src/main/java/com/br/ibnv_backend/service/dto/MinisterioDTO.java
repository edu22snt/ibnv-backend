package com.br.ibnv_backend.service.dto;

import java.io.Serializable;

public class MinisterioDTO implements Serializable {

    private Long id;
    private String nome;
    private MembroDTO lider;
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

    public MembroDTO getLider() {
        return lider;
    }

    public void setLider(MembroDTO lider) {
        this.lider = lider;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
