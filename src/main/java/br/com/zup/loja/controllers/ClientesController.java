package br.com.zup.loja.controllers;

import br.com.zup.loja.models.Cliente;
import br.com.zup.loja.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes/")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionarCliente(@RequestBody @Valid Cliente cliente) {
        return clientesService.adicionarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodosOsClientes() {
        return clientesService.getClientes();
    }

    @GetMapping("{cpf}/")
    public Cliente pesquisarClientePeloCPF(@PathVariable String cpf) {
        return clientesService.pesquisarClientePeloCPF(cpf);
    }
}
