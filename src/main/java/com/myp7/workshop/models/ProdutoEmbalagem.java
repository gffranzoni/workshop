package com.myp7.workshop.models;

import com.myp7.workshop.models.enums.Embalagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "produtoembalagem")
public class ProdutoEmbalagem {

    @Id
    @SequenceGenerator(name = "produto_embalagem_seq_gen", sequenceName = "produto_embalagem_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_embalagem_seq_gen")
    private Long id;

    @Column(name = "tipoembalagem", nullable = false)
    @Enumerated(EnumType.STRING)
    private Embalagem tipoEmbalagem;

    @Column(name = "codigodebarras", nullable = false, length = 20)
    private String codigoDeBarras;

    @Positive(message = "A quantidade deve ser um valor positivo")
    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idproduto", nullable = false, foreignKey = @ForeignKey(name = "fk_produto_embalagem_produto"))
    private Produto produto;

    public ProdutoEmbalagem() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
