package br.com.zup.loja.services;

import br.com.zup.loja.exceptions.ProdutoEmFaltaException;
import br.com.zup.loja.models.Cliente;
import br.com.zup.loja.models.Compra;
import br.com.zup.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComprasService {
    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ProdutosService produtosService;

    private List<Compra> compras;

    public ComprasService() {
        compras = new ArrayList<>();
    }

    /**
     * Adiciona uma compra no sistema
     *
     * @param cpfDoCliente string contendo o CPF do cliente que vai fazer a compra
     * @param nomeDoProduto string contendo o nome do produto comprado
     * @return objeto compra
     */
    public Compra adicionarCompra(String cpfDoCliente, String nomeDoProduto) {
        Cliente cliente = clientesService.pesquisarClientePeloCPF(cpfDoCliente);
        Produto produto = produtosService.pesquisarProdutoPeloNome(nomeDoProduto);

        if (produto.getQuantidade() <= 0) {
            throw new ProdutoEmFaltaException(produto.getNome());
        }

        Compra compra = new Compra(cliente, Arrays.asList(produto));
        compras.add(compra);
        produto.setQuantidade(produto.getQuantidade() - 1);
        return compra;
    }

    /**
     * Retorna a lista de todas as compras cadastradas no sistema
     *
     * @return lista de compras
     */
    public List<Compra> getCompras() {
        return compras;
    }

    /**
     * Lista as compras de um cliente específico
     * @param cpfDoCliente string contendo o CPF do cliente para criar a lista
     * @return lista de compras
     */
    public List<Compra> listarComprasDoCliente(String cpfDoCliente) {
        List <Compra> listaDeComprasDoCliente = new ArrayList<>();

        for (Compra compra: compras) {
            if (compra.getCliente().getCpf().equals(cpfDoCliente)) {
                listaDeComprasDoCliente.add(compra);
            }
        }

        return listaDeComprasDoCliente;
    }
}
