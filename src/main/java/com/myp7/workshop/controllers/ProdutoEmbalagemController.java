package com.myp7.workshop.controllers;

import com.myp7.workshop.models.Produto;
import com.myp7.workshop.models.ProdutoEmbalagem;
import com.myp7.workshop.models.enums.Embalagem;
import com.myp7.workshop.services.ProdutoService;
import com.myp7.workshop.services.ProdutoEmbalagemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos/{produtoId}/embalagens")
public class ProdutoEmbalagemController {

    private final ProdutoService produtoService;
    private final ProdutoEmbalagemService produtoEmbalagemService;

    public ProdutoEmbalagemController(ProdutoService produtoService, ProdutoEmbalagemService produtoEmbalagemService) {
        this.produtoService = produtoService;
        this.produtoEmbalagemService = produtoEmbalagemService;
    }

    @GetMapping
    public String listar(@PathVariable Long produtoId, Model model) {
        Produto produto = produtoService.buscarPorId(produtoId);
        model.addAttribute("produto", produto);
        model.addAttribute("embalagens", produtoEmbalagemService.listarPorProduto(produtoId));
        model.addAttribute("tiposEmbalagem", Embalagem.values());
        return "embalagens/list";
    }

    @GetMapping("/novo")
    public String novo(@PathVariable Long produtoId, Model model) {
        Produto produto = produtoService.buscarPorId(produtoId);
        ProdutoEmbalagem embalagem = new ProdutoEmbalagem();
        embalagem.setProduto(produto);

        model.addAttribute("produto", produto);
        model.addAttribute("embalagemForm", embalagem);
        model.addAttribute("tiposEmbalagem", Embalagem.values());
        model.addAttribute("acao", "/produtos/" + produtoId + "/embalagens");
        model.addAttribute("titulo", "Nova embalagem");
        return "embalagens/form";
    }

    @PostMapping
    public String criar(@PathVariable Long produtoId, @Valid @ModelAttribute("embalagemForm") ProdutoEmbalagem embalagem, BindingResult bindingResult, Model model) {
        Produto produto = produtoService.buscarPorId(produtoId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("produto", produto);
            model.addAttribute("embalagemForm", embalagem);
            model.addAttribute("tiposEmbalagem", Embalagem.values());
            model.addAttribute("acao", "/produtos/" + produtoId + "/embalagens");
            model.addAttribute("titulo", "Nova embalagem");
            return "embalagens/form";
        }

        embalagem.setProduto(produto);
        produtoEmbalagemService.criar(embalagem);
        return "redirect:/produtos/{produtoId}/embalagens";
    }

    @GetMapping("/{id:\\d+}/editar")
    public String editar(@PathVariable Long produtoId, @PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(produtoId);
        ProdutoEmbalagem embalagem = produtoEmbalagemService.buscarPorId(id);

        model.addAttribute("produto", produto);
        model.addAttribute("embalagemForm", embalagem);
        model.addAttribute("tiposEmbalagem", Embalagem.values());
        model.addAttribute("acao", "/produtos/" + produtoId + "/embalagens/" + id);
        model.addAttribute("titulo", "Editar embalagem");
        return "embalagens/form";
    }

    @PostMapping("/{id:\\d+}")
    public String atualizar(@PathVariable Long produtoId, @PathVariable Long id, @Valid @ModelAttribute("embalagemForm") ProdutoEmbalagem embalagem, BindingResult bindingResult, Model model) {
        Produto produto = produtoService.buscarPorId(produtoId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("produto", produto);
            model.addAttribute("embalagemForm", embalagem);
            model.addAttribute("tiposEmbalagem", Embalagem.values());
            model.addAttribute("acao", "/produtos/" + produtoId + "/embalagens/" + id);
            model.addAttribute("titulo", "Editar embalagem");
            return "embalagens/form";
        }

        produtoEmbalagemService.atualizar(id, embalagem);
        return "redirect:/produtos/{produtoId}/embalagens";
    }

    @PostMapping("/{id:\\d+}/excluir")
    public String excluir(@PathVariable Long produtoId, @PathVariable Long id) {
        produtoEmbalagemService.remover(id);
        return "redirect:/produtos/{produtoId}/embalagens";
    }
}
