package com.br.ibnv_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "TB_MEMBRO")
public class Membro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MEMBRO")
    private Long id;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="NM_LIDER")
    private String liderDireto;

    @Column(name="NM_EMAIL")
    private String email;

    @Column(name="NO_TELEFONE")
    private String numTelefone;

    @Column(name="DT_DATA_NASCIMENTO")
    private LocalDateTime dataNascimento;

    @Column(name="NM_SEXO")
    private String sexo;

    @Column(name="NM_ESTADO_CIVIL")
    private String estadoCivil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_ENDERECO")
    private Endereco endereco;

    @Column(name = "NU_ATIVO")
    private Integer ativo;

    @Column(name = "DT_DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name = "DT_DATA_BATISMO")
    private LocalDateTime dataBatismo;

    @Column(name="IS_LIDER")
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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
