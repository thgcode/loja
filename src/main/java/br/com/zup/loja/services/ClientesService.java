package br.com.zup.loja.services;

import br.com.zup.loja.exceptions.CPFRepetidoException;
import br.com.zup.loja.exceptions.ClienteNaoEncontradoException;
import br.com.zup.loja.exceptions.EmailRepetidoException;
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

    public void validarAdicionarCliente(Cliente cliente) {
        try {
            pesquisarClientePeloCPF(cliente.getCpf());
            throw new CPFRepetidoException();
        } catch (ClienteNaoEncontradoException erro) {
            pesquisarClientePeloEmail(cliente.getEmail());
        }
    }

    public Cliente adicionarCliente(Cliente cliente) {
        try {
            validarAdicionarCliente(cliente);
        } catch (ClienteNaoEncontradoException erro) {
            clientes.add(cliente);
            return cliente;
        }

        throw new EmailRepetidoException();
    }

    public Cliente pesquisarClientePeloCPF(String cpfDoCliente) {
        for (Cliente cliente: clientes) {
            if (cliente.getCpf().equals(cpfDoCliente)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    public Cliente pesquisarClientePeloEmail(String emailDoCliente) {
        for (Cliente cliente: clientes) {
            if (cliente.getEmail().equalsIgnoreCase(emailDoCliente)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
