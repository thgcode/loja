package br.com.zup.loja.dto;

import br.com.zup.loja.exceptions.ErroNoSistema;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class RespostaDeErro {
    private String tipoDoErro;
    private HttpStatus statusDeErro;
    private List<Erro> erros;

    public RespostaDeErro() {
    }

    public RespostaDeErro(String tipoDoErro, HttpStatus statusDeErro, List<Erro> erros) {
        this.tipoDoErro = tipoDoErro;
        this.statusDeErro = statusDeErro;
        this.erros = erros;
    }

    public String getTipoDoErro() {
        return tipoDoErro;
    }

    public void setTipoDoErro(String tipoDoErro) {
        this.tipoDoErro = tipoDoErro;
    }

    public HttpStatus getStatusDeErro() {
        return statusDeErro;
    }

    public void setStatusDeErro(HttpStatus statusDeErro) {
        this.statusDeErro = statusDeErro;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }

    public static RespostaDeErro criaApartirDeErro(ErroNoSistema erro) {
        return new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), Arrays.asList(new Erro(null, erro.getMessage())));
    }
}