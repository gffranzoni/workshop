package com.myp7.workshop.api.dto;

import com.myp7.workshop.models.enums.Embalagem;

public class ProdutoEmbalagemResponse {

    private Long id;
    private Embalagem embalagem;
    private String codigoDeBarras;
    private Double quantidade;

    public ProdutoEmbalagemResponse() {
    }

    public ProdutoEmbalagemResponse(Long id, Embalagem embalagem, String codigoDeBarras, Double quantidade) {
        this.id = id;
        this.embalagem = embalagem;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}

