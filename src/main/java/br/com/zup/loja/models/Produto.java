package br.com.zup.loja.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Produto {
    @NotEmpty
    private String nome;

    @Positive
    private double preco;

    @Positive
    private int quantidade;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
