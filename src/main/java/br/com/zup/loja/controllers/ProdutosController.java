package br.com.zup.loja.controllers;

import br.com.zup.loja.models.Produto;
import br.com.zup.loja.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutosController {
    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@Valid @RequestBody Produto produto) {
        return produtosService.adicionarProduto(produto);
    }

    @GetMapping()
    public List<Produto> listarTodosOsProdutos() {
        return produtosService.getProdutos();
    }
}
