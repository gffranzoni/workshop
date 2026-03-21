package com.myp7.workshop.controllers;

import com.myp7.workshop.models.Produto;
import com.myp7.workshop.services.ProdutoService;
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
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listar());
        return "produtos/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produtoForm", new Produto());
        model.addAttribute("acao", "/produtos");
        model.addAttribute("titulo", "Novo produto");
        return "produtos/form";
    }

    @PostMapping
    public String criar(@Valid @ModelAttribute("produtoForm") Produto produto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("acao", "/produtos");
            model.addAttribute("titulo", "Novo produto");
            return "produtos/form";
        }

        produtoService.criar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        model.addAttribute("produtoForm", produto);
        model.addAttribute("acao", "/produtos/" + id);
        model.addAttribute("titulo", "Editar produto");
        model.addAttribute("produtoId", id);
        return "produtos/form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute("produtoForm") Produto produto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("acao", "/produtos/" + id);
            model.addAttribute("titulo", "Editar produto");
            model.addAttribute("produtoId", id);
            return "produtos/form";
        }

        produtoService.atualizar(id, produto);
        return "redirect:/produtos";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        produtoService.remover(id);
        return "redirect:/produtos";
    }
}
