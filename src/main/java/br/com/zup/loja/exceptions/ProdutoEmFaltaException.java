package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoEmFaltaException extends ErroNoSistema {
    public ProdutoEmFaltaException(String nomeDoProduto) {
        super(HttpStatus.PRECONDITION_FAILED, "compra", "Produto " + nomeDoProduto + " está em falta no sistema");
    }
}
