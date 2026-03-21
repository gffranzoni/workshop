package com.myp7.workshop.services;

import com.myp7.workshop.models.Produto;
import com.myp7.workshop.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com id: " + id));
    }

    public Produto criar(Produto produto){
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto){
        Produto existente = buscarPorId(id);
        existente.setDescricao(produto.getDescricao());
        existente.setCodigoFabricante(produto.getCodigoFabricante());
        return produtoRepository.save(existente);
    }

    public void deletar(Long id){
        Produto existente = buscarPorId(id);
        produtoRepository.delete(existente);
    }
}
