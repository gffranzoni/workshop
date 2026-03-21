package com.myp7.workshop.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "produto_seq_gen", sequenceName = "produto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq_gen")
    private Long id;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "codigofabricante", nullable = false, length = 20)
    private String codigoFabricante;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoEmbalagem> embalagens = new ArrayList<>();

    public Produto() {
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

    public List<ProdutoEmbalagem> getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(List<ProdutoEmbalagem> embalagens) {
        this.embalagens = embalagens;
    }
}
