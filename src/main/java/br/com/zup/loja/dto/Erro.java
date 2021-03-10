package br.com.zup.loja.dto;

public class Erro {
    private String onde;
    private String mensagem;

    public Erro() {
    }

    public Erro(String onde, String mensagem) {
        this.onde = onde;
        this.mensagem = mensagem;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
