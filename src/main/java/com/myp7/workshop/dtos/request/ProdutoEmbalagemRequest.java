package com.myp7.workshop.dtos.request;

import com.myp7.workshop.models.enums.Embalagem;

public class ProdutoEmbalagemRequest {

    private Embalagem tipoEmbalagem;

    private String codigoDeBarras;

    private Double quantidade;

    public ProdutoEmbalagemRequest() {
    }

    public ProdutoEmbalagemRequest(Embalagem tipoEmbalagem, String codigoDeBarras, Double quantidade) {
        this.tipoEmbalagem = tipoEmbalagem;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = quantidade;
    }

    public Embalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(Embalagem tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
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

