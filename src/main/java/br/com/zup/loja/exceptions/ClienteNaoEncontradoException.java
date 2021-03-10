package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteNaoEncontradoException extends ErroNoSistema{
    public ClienteNaoEncontradoException() {
        super(HttpStatus.BAD_REQUEST, "cliente", "Cliente não encontrado");
    }
}
