package br.com.zup.loja.services;

import br.com.zup.loja.models.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprasService {
    private List<Compra> compras;

    public ComprasService() {
        compras = new ArrayList<>();
    }

    public Compra adicionarCompra(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public List<Compra> listarTodasAsCompras() {
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
