package com.myp7.workshop.dtos.request;

import com.myp7.workshop.models.ProdutoEmbalagem;

import java.util.List;

public class ProdutoRequest {

    private String descricao;
    private String codigoFabricante;
    private List<ProdutoEmbalagemRequest> produtoEmbalagem;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String descricao, String codigoFabricante, List<ProdutoEmbalagemRequest> produtoEmbalagem) {
        this.descricao = descricao;
        this.codigoFabricante = codigoFabricante;
        this.produtoEmbalagem = produtoEmbalagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public List<ProdutoEmbalagemRequest> getProdutoEmbalagem() {
        return produtoEmbalagem;
    }

    public void setProdutoEmbalagem(List<ProdutoEmbalagemRequest> produtoEmbalagem) {
        this.produtoEmbalagem = produtoEmbalagem;
    }
}
