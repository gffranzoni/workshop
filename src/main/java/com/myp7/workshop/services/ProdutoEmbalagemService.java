package com.myp7.workshop.services;

import com.myp7.workshop.models.ProdutoEmbalagem;
import com.myp7.workshop.repositories.ProdutoEmbalagemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoEmbalagemService {

    private final ProdutoEmbalagemRepository produtoEmbalagemRepository;

    public ProdutoEmbalagemService(ProdutoEmbalagemRepository produtoEmbalagemRepository) {
        this.produtoEmbalagemRepository = produtoEmbalagemRepository;
    }

    public List<ProdutoEmbalagem> listarPorProduto(Long produtoId) {
        return produtoEmbalagemRepository.findByProdutoId(produtoId);
    }

    public ProdutoEmbalagem buscarPorId(Long id) {
        return produtoEmbalagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Embalagem nao encontrada: " + id));
    }

    public ProdutoEmbalagem criar(@Valid ProdutoEmbalagem embalagem) {
        embalagem.setId(null);
        return produtoEmbalagemRepository.save(embalagem);
    }

    public ProdutoEmbalagem atualizar(Long id, ProdutoEmbalagem dadosAtualizados) {
        ProdutoEmbalagem existente = buscarPorId(id);
        existente.setEmbalagem(dadosAtualizados.getEmbalagem());
        existente.setCodigoDeBarras(dadosAtualizados.getCodigoDeBarras());
        existente.setQuantidade(dadosAtualizados.getQuantidade());
        return produtoEmbalagemRepository.save(existente);
    }

    public void remover(Long id) {
        ProdutoEmbalagem existente = buscarPorId(id);
        produtoEmbalagemRepository.delete(existente);
    }
}

