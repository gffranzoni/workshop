package com.myp7.workshop.api.dto;

import com.myp7.workshop.models.enums.Embalagem;

public class ProdutoEmbalagemRequest {

    private Embalagem embalagem;

    private String codigoDeBarras;

    private Double quantidade;

    public ProdutoEmbalagemRequest() {
    }

    public ProdutoEmbalagemRequest(Embalagem embalagem, String codigoDeBarras, Double quantidade) {
        this.embalagem = embalagem;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = quantidade;
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

