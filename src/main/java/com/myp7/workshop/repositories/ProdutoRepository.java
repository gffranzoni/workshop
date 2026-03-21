package com.myp7.workshop.repositories;

import com.myp7.workshop.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

