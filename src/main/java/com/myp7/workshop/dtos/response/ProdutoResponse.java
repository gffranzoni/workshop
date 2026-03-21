package com.myp7.workshop.dtos.response;

import com.myp7.workshop.dtos.request.ProdutoEmbalagemRequest;

import java.util.List;

public class ProdutoResponse {

    private Long id;
    private String descricao;
    private String codigoFabricante;
    private List<ProdutoEmbalagemResponse> produtoEmbalagem;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String descricao, String codigoFabricante, List<ProdutoEmbalagemResponse> produtoEmbalagem) {
        this.id = id;
        this.descricao = descricao;
        this.codigoFabricante = codigoFabricante;
        this.produtoEmbalagem = produtoEmbalagem;
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

    public List<ProdutoEmbalagemResponse> getProdutoEmbalagem() {
        return produtoEmbalagem;
    }

    public void setProdutoEmbalagem(List<ProdutoEmbalagemResponse> produtoEmbalagem) {
        this.produtoEmbalagem = produtoEmbalagem;
    }
}
