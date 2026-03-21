package com.myp7.workshop.controller;

import com.myp7.workshop.dtos.request.ProdutoRequest;
import com.myp7.workshop.dtos.response.ProdutoEmbalagemResponse;
import com.myp7.workshop.dtos.response.ProdutoResponse;
import com.myp7.workshop.models.Produto;
import com.myp7.workshop.models.ProdutoEmbalagem;
import com.myp7.workshop.services.ProdutoEmbalagemService;
import com.myp7.workshop.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/produtos")
public class ProdutoAPIController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoEmbalagemService produtoEmbalagemService;


    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar(){
        List<Produto> produtos = produtoService.listar();

        List<ProdutoResponse> responses = produtos.stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> criar (@RequestBody ProdutoRequest produtoRequest){
        //Criar produto
        Produto produto = new Produto();
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setCodigoFabricante(produtoRequest.getCodigoFabricante());

        Produto produtoSalvo = produtoService.criar(produto);

        // Criar embalagens associadas

        if (produtoRequest.getProdutoEmbalagem() != null && !produtoRequest.getProdutoEmbalagem().isEmpty()) {
           produtoRequest.getProdutoEmbalagem().forEach(produtoEmbalagemRequest -> {
               ProdutoEmbalagem embalagem = new ProdutoEmbalagem();
               embalagem.setProduto(produtoSalvo);
               embalagem.setTipoEmbalagem(produtoEmbalagemRequest.getTipoEmbalagem());
               embalagem.setCodigoDeBarras(produtoEmbalagemRequest.getCodigoDeBarras());
               embalagem.setQuantidade(produtoEmbalagemRequest.getQuantidade());
               produtoEmbalagemService.criar(embalagem);
           });
        }

        ProdutoResponse response = converterParaResponse(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    private ProdutoResponse converterParaResponse(Produto produto) {
        List<ProdutoEmbalagemResponse> embalagens = produtoEmbalagemService.listarPorProduto(produto.getId())
                .stream()
                .map(embalagem -> new ProdutoEmbalagemResponse(
                        embalagem.getTipoEmbalagem(),
                        embalagem.getCodigoDeBarras(),
                        embalagem.getQuantidade()
                )).collect(Collectors.toList());



        return new ProdutoResponse(
                produto.getId(),
                produto.getDescricao(),
                produto.getCodigoFabricante(),
                embalagens
        );
    }
}
