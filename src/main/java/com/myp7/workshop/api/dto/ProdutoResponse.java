package com.myp7.workshop.api.dto;

import java.util.List;

public class ProdutoResponse {

    private Long id;
    private String descricao;
    private String codigoFabricante;
    private Double preco;
    private List<ProdutoEmbalagemResponse> embalagens;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String descricao, String codigoFabricante, Double preco, List<ProdutoEmbalagemResponse> embalagens) {
        this.id = id;
        this.descricao = descricao;
        this.codigoFabricante = codigoFabricante;
        this.preco = preco;
        this.embalagens = embalagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ProdutoEmbalagemResponse> getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(List<ProdutoEmbalagemResponse> embalagens) {
        this.embalagens = embalagens;
    }
}

