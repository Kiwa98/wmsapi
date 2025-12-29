package com.example.wmsapi.DTO;

public class EstoqueLocalRequest {

    private String localizacao;
    private int quantidade;

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
