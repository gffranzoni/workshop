package com.myp7.workshop.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "produto_seq_gen", sequenceName = "produto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq_gen")
    private Long id;

    @NotNull(message = "A descrição é obrigatória")
    @NotBlank(message = "A descrição não pode ser vazia")
    @Column(nullable = false, length = 120)
    private String descricao;

    @NotNull(message = "O código do fabricante é obrigatório")
    @NotBlank(message = "O código do fabricante não pode ser vazio")
    @Column(nullable = false, length = 60)
    private String codigoFabricante;

    @Column(nullable = false)
    private Double preco;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoEmbalagem> embalagens = new ArrayList<>();

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

    public List<ProdutoEmbalagem> getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(List<ProdutoEmbalagem> embalagens) {
        this.embalagens = embalagens;
    }

    public void addEmbalagem(ProdutoEmbalagem embalagem) {
        embalagens.add(embalagem);
        embalagem.setProduto(this);
    }

    public void removeEmbalagem(ProdutoEmbalagem embalagem) {
        embalagens.remove(embalagem);
        embalagem.setProduto(null);
    }
}
