package com.myp7.workshop.services;

import com.myp7.workshop.models.Produto;
import com.myp7.workshop.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto nao encontrado: " + id));
    }

    public Produto criar(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto dadosAtualizados) {
        Produto existente = buscarPorId(id);
        existente.setDescricao(dadosAtualizados.getDescricao());
        existente.setCodigoFabricante(dadosAtualizados.getCodigoFabricante());
        existente.setPreco(dadosAtualizados.getPreco());
        return produtoRepository.save(existente);
    }

    public void remover(Long id) {
        Produto existente = buscarPorId(id);
        produtoRepository.delete(existente);
    }
}

