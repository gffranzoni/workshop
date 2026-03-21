package com.myp7.workshop.api.controller;

import com.myp7.workshop.api.dto.ProdutoEmbalagemResponse;
import com.myp7.workshop.api.dto.ProdutoRequest;
import com.myp7.workshop.api.dto.ProdutoResponse;
import com.myp7.workshop.models.Produto;
import com.myp7.workshop.models.ProdutoEmbalagem;
import com.myp7.workshop.services.ProdutoEmbalagemService;
import com.myp7.workshop.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ws/produtos")
public class ProdutoAPI {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoEmbalagemService produtoEmbalagemService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar() {
        List<Produto> produtos = produtoService.listar();
        List<ProdutoResponse> responses = produtos.stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest request) {
        // Criar o produto
        Produto produto = new Produto();
        produto.setDescricao(request.getDescricao());
        produto.setCodigoFabricante(request.getCodigoFabricante());
        produto.setPreco(request.getPreco());

        // Validação ocorre ao salvar (Spring valida a Entity)
        Produto produtoSalvo = produtoService.criar(produto);

        // Criar embalagens associadas
        if (request.getEmbalagens() != null && !request.getEmbalagens().isEmpty()) {
            request.getEmbalagens().forEach(embalagemRequest -> {
                ProdutoEmbalagem embalagem = new ProdutoEmbalagem();
                embalagem.setProduto(produtoSalvo);
                embalagem.setEmbalagem(embalagemRequest.getEmbalagem());
                embalagem.setCodigoDeBarras(embalagemRequest.getCodigoDeBarras());
                embalagem.setQuantidade(embalagemRequest.getQuantidade());

                // Validação ocorre ao salvar (Spring valida a Entity)
                produtoEmbalagemService.criar(embalagem);
            });
        }

        // Buscar produto com embalagens e converter para response
        Produto produtoComEmbalagens = produtoService.buscarPorId(produtoSalvo.getId());
        ProdutoResponse response = converterParaResponse(produtoComEmbalagens);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private ProdutoResponse converterParaResponse(Produto produto) {
        List<ProdutoEmbalagemResponse> embalagens = produtoEmbalagemService.listarPorProduto(produto.getId())
                .stream()
                .map(embalagem -> new ProdutoEmbalagemResponse(
                        embalagem.getId(),
                        embalagem.getEmbalagem(),
                        embalagem.getCodigoDeBarras(),
                        embalagem.getQuantidade()
                ))
                .collect(Collectors.toList());

        return new ProdutoResponse(
                produto.getId(),
                produto.getDescricao(),
                produto.getCodigoFabricante(),
                produto.getPreco(),
                embalagens
        );
    }
}

