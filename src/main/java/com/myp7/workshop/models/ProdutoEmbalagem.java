package com.myp7.workshop.models;

import com.myp7.workshop.models.enums.Embalagem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "produto_embalagem",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_produto_embalagem_tipo", columnNames = {"produto_id", "tipo_embalagem"}),
                @UniqueConstraint(name = "uk_produto_embalagem_barras", columnNames = {"produto_id", "codigo_barras"})
        }
)
public class ProdutoEmbalagem {

    @Id
    @SequenceGenerator(name = "produto_embalagem_seq_gen", sequenceName = "produto_embalagem_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_embalagem_seq_gen")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_embalagem", nullable = false, length = 20)
    private Embalagem embalagem;

    @Column(name = "codigo_barras", nullable = false, length = 40)
    private String codigoDeBarras;

    @Column(nullable = false)
    private Double quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
