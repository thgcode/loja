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

    /**
     * Adiciona um produto no sistema
     *
     * @param produto o produto a ser adicionado
     * @return produto
     */
    public Produto adicionarProduto(Produto produto) {
        try {
            pesquisarProdutoPeloNome(produto.getNome());
        } catch (ProdutoNaoEncontradoException erro) {
            produtos.add(produto);
            return produto;
        }

        throw new ProdutoRepetidoException();
    }

    /**
     * Pesquisa um produto pelo nome cadastrado
     *
     * @param nomeDoProduto string com o nome do produto
     * @return produto
     */
    public Produto pesquisarProdutoPeloNome(String nomeDoProduto) {
        for (Produto produto: produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeDoProduto)) {
                return produto;
            }
        }

        throw new ProdutoNaoEncontradoException();
    }

    /**
     * Lista todos os produtos cadastrados no sistema
     *
     * @return lista de produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }
}
