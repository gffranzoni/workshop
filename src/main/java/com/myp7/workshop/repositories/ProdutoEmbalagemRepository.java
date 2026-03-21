package com.myp7.workshop.repositories;

import com.myp7.workshop.models.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem,Long> {
    List<ProdutoEmbalagem> findByProdutoId(Long produtoId);
}
