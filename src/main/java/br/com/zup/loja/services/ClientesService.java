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

    /**
     *Verifica se o cliente pode ser adicionado na lista. Se esse método passar pelo fluxo normal do programa, significa que o cliente pode ser adicionado no sistema
     *
     * @param cliente o cliente a verificar
     */
    public void validarAdicionarCliente(Cliente cliente) {
        try {
            pesquisarClientePeloCPF(cliente.getCpf());
            throw new CPFRepetidoException();
        } catch (ClienteNaoEncontradoException erro) {
            pesquisarClientePeloEmail(cliente.getEmail());
        }
    }

    /**
     * Adiciona um cliente no sistema
     *
     * @param cliente o cliente a ser adicionado
     * @return cliente
     */
    public Cliente adicionarCliente(Cliente cliente) {
        try {
            validarAdicionarCliente(cliente);
        } catch (ClienteNaoEncontradoException erro) {
            clientes.add(cliente);
            return cliente;
        }

        throw new EmailRepetidoException();
    }

    /**
     * Pesquisa um cliente pelo CPF
     *
     * @param cpfDoCliente string contendo o CPF
     * @return cliente
     */
    public Cliente pesquisarClientePeloCPF(String cpfDoCliente) {
        for (Cliente cliente: clientes) {
            if (cliente.getCpf().equals(cpfDoCliente)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    /**
     * Pesquisa um cliente pelo e-mail
     *
     * @param emailDoCliente string contendo o e-mail
     * @return cliente
     */
    public Cliente pesquisarClientePeloEmail(String emailDoCliente) {
        for (Cliente cliente: clientes) {
            if (cliente.getEmail().equalsIgnoreCase(emailDoCliente)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    /**
     * Lista todos os clientes cadastrados no sistema
     *
     * @return lista de clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }
}
