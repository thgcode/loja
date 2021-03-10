package br.com.zup.loja.controllers;

import br.com.zup.loja.models.Produto;
import br.com.zup.loja.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("produtos/")
public class ProdutosController {
    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    public Produto adicionarProduto(@Valid @RequestBody Produto produto) {
        return produtosService.adicionarProduto(produto);
    }
}
