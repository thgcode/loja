package br.com.zup.loja.services;

import br.com.zup.loja.exceptions.ProdutoNaoEncontradoException;
import br.com.zup.loja.exceptions.ProdutoRepetidoException;
import br.com.zup.loja.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutosService {
    private List<Produto> produtos;

    public ProdutosService() {
        produtos = new ArrayList<>();
    }

    public Produto adicionarProduto(Produto produto) {
        try {
            pesquisarProduto(produto.getNome());
        } catch (ProdutoNaoEncontradoException erro) {
            produtos.add(produto);
            return produto;
        }

        throw new ProdutoRepetidoException();
    }

    public Produto pesquisarProduto(String nomeDoProduto) {
        for (Produto produto: produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeDoProduto)) {
                return produto;
            }
        }

        throw new ProdutoNaoEncontradoException();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
