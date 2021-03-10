package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoNaoEncontradoException extends ErroNoSistema {
    public ProdutoNaoEncontradoException() {
        super(HttpStatus.BAD_REQUEST, "produto", "Produto não encontrado");
    }
}
