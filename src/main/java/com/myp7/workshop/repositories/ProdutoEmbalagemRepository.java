package com.myp7.workshop.repositories;

import com.myp7.workshop.models.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
    List<ProdutoEmbalagem> findByProdutoId(Long produtoId);
}

