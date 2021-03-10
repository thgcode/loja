package br.com.zup.loja.exceptions;

import org.springframework.http.HttpStatus;

public class ErroNoSistema extends RuntimeException {
    private HttpStatus status;
    private String tipoDoErro;

    public ErroNoSistema(HttpStatus status, String tipoDoErro, String mensagem) {
        super(mensagem);
        this.status = status;
        this.tipoDoErro = tipoDoErro;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getTipoDoErro() {
        return tipoDoErro;
    }
}
