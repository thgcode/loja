package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class EmailRepetidoException extends ErroNoSistema {
    public EmailRepetidoException() {
        super(HttpStatus.BAD_REQUEST, "cliente", "E-mail do cliente já foi cadastrado no sistema");
    }
}
