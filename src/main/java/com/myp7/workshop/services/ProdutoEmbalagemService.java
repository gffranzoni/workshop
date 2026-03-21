package com.myp7.workshop.services;

import com.myp7.workshop.models.ProdutoEmbalagem;
import com.myp7.workshop.repositories.ProdutoEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoEmbalagemService {

    @Autowired
    private ProdutoEmbalagemRepository produtoEmbalagemRepository;

    public ProdutoEmbalagem criar(ProdutoEmbalagem embalagem) {
        embalagem.setId(null);
        return produtoEmbalagemRepository.save(embalagem);
    }

    public List<ProdutoEmbalagem> listarPorProduto(Long produtoId){
        return produtoEmbalagemRepository.findByProdutoId(produtoId);
    }
}
