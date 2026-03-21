package com.myp7.workshop.api.dto;

import java.util.List;

public class ProdutoRequest {

    private String descricao;

    private String codigoFabricante;

    private Double preco;

    private List<ProdutoEmbalagemRequest> embalagens;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String descricao, String codigoFabricante, Double preco, List<ProdutoEmbalagemRequest> embalagens) {
        this.descricao = descricao;
        this.codigoFabricante = codigoFabricante;
        this.preco = preco;
        this.embalagens = embalagens;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<ProdutoEmbalagemRequest> getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(List<ProdutoEmbalagemRequest> embalagens) {
        this.embalagens = embalagens;
    }
}

