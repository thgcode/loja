package br.com.zup.loja.services;

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

    public Compra adicionarCompra(String cpfDoCliente, String nomeDoProduto) {
        Cliente cliente = clientesService.pesquisarClientePeloCPF(cpfDoCliente);
        Produto produto = produtosService.pesquisarProdutoPeloNome(nomeDoProduto);

        Compra compra = new Compra(cliente, Arrays.asList(produto));
        compras.add(compra);
        return compra;
    }

    public List<Compra> getCompras() {
        return compras;
    }

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
