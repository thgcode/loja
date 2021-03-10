package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class CPFRepetidoException extends ErroNoSistema {
    public CPFRepetidoException() {
        super(HttpStatus.BAD_REQUEST, "cliente", "CPF repetido");
    }
}
