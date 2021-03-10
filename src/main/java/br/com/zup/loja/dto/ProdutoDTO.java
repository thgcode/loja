package br.com.zup.loja.dto;

import br.com.zup.loja.models.Produto;

public class ProdutoDTO {
    private String nome;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeDoProduto) {
        this.nome = nomeDoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
