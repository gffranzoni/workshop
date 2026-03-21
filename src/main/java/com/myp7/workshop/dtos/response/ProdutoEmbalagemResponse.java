package com.myp7.workshop.dtos.response;

import com.myp7.workshop.dtos.request.ProdutoEmbalagemRequest;
import com.myp7.workshop.models.enums.Embalagem;

import java.util.List;

public class ProdutoEmbalagemResponse {

    private Embalagem tipoEmbalagem;

    private String codigoDeBarras;

    private Double quantidade;

    public ProdutoEmbalagemResponse() {
    }

    public ProdutoEmbalagemResponse(Embalagem tipoEmbalagem, String codigoDeBarras, Double quantidade) {
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
