package com.myp7.workshop.models;

import com.myp7.workshop.models.enums.Embalagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_produto_embalagem_produto"))
    private Produto produto;

    @NotNull(message = "O tipo de embalagem é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_embalagem", nullable = false, length = 20)
    private Embalagem embalagem;

    @NotNull(message = "O código de barras é obrigatório")
    @NotBlank(message = "O código de barras não pode ser vazio")
    @Column(name = "codigo_barras", nullable = false, length = 40)
    private String codigoDeBarras;

    @Positive(message = "A quantidade deve ser maior que zero")
    @NotNull(message = "A quantidade é obrigatória")
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
