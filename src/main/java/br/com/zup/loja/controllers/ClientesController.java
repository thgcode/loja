package br.com.zup.loja.controllers;

import br.com.zup.loja.models.Cliente;
import br.com.zup.loja.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes/")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public Cliente adicionarCliente(@RequestBody @Valid Cliente cliente) {
        return clientesService.adicionarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodosOsclientes() {
        return clientesService.getClientes();
    }
}
