package br.com.zup.loja.services;

import br.com.zup.loja.exceptions.CPFRepetidoException;
import br.com.zup.loja.exceptions.ClienteNaoEncontradoException;
import br.com.zup.loja.exceptions.ProdutoNaoEncontradoException;
import br.com.zup.loja.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesService {
    private List<Cliente> clientes;

    public ClientesService() {
        clientes = new ArrayList<>();
    }

    public Cliente adicionarCliente(Cliente cliente) {
        try {
            pesquisarClientePeloCPF(cliente.getCpf());
        } catch (ClienteNaoEncontradoException erro) {
            clientes.add(cliente);
            return cliente;
        }

        throw new CPFRepetidoException();
    }

    public Cliente pesquisarClientePeloCPF(String cpf) {
        for (Cliente cliente: clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
