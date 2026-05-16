package com.br.ibnv_backend.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MembroDTO implements Serializable {

    private Long id;
    private String nome;
    private String liderDireto;
    private String email;
    private String numTelefone;
    private LocalDateTime dataNascimento;
    private String sexo;
    private String estadoCivil;
    private EnderecoDTO endereco;
    private Integer ativo;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataBatismo;
    private Integer lider;

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

    public String getLiderDireto() {
        return liderDireto;
    }

    public void setLiderDireto(String liderDireto) {
        this.liderDireto = liderDireto;
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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDateTime dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Integer isLider() {
        return lider;
    }

    public void setLider(Integer lider) {
        this.lider = lider;
    }
}
