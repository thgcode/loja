package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoRepetidoException extends ErroNoSistema {
    public ProdutoRepetidoException() {
        super(HttpStatus.BAD_REQUEST, "produto", "Produto repetido");
    }
}
