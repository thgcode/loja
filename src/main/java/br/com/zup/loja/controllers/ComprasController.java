package br.com.zup.loja.controllers;

import br.com.zup.loja.dto.ComprasDTO;
import br.com.zup.loja.dto.ProdutoDTO;
import br.com.zup.loja.models.Compra;
import br.com.zup.loja.services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("compras/")
public class ComprasController {
    @Autowired
    private ComprasService comprasService;


    @PostMapping
    public ComprasDTO adicionarCompra(@Valid @RequestBody ComprasDTO compras) {
        ComprasDTO resultado = new ComprasDTO();
        resultado.setCpf(compras.getCpf());
        resultado.setProdutos(new ArrayList<ProdutoDTO>());

        for (ProdutoDTO produto : compras.getProdutos()) {
            Compra compra = comprasService.adicionarCompra(compras.getCpf(), produto.getNome());
            resultado.getProdutos().add(new ProdutoDTO(produto.getNome()));
        }

        return resultado;
    }

    @GetMapping
    public List<Compra> listarTodasAsCompras() {
        return comprasService.getCompras();
    }

    @GetMapping("{cpf}/")
    public List <Compra> listarComprasDoCliente(@PathVariable String cpf) {
return comprasService.listarComprasDoCliente(cpf);
    }
    }