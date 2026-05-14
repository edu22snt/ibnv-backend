package com.br.ibnv_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_NOTA_FISCAL")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CD_NOTA_FISCAL")
    private Long id;

    @Column(name="NM_NOME_ARQUIVO")
    private String nomeArquivo;

    @Column(name="NM_TIPO_ARQUIVO")
    private String tipoArquivo;

    @Column(name = "DS_CAMINHO_IMAGEM")
    private String caminhoImagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
