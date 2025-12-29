package com.example.wmsapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id; // ✅ IMPORT CORRETO

@Entity
public class EstoqueLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Estoque produto;

    private String localizacao;

    private int quantidade;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Estoque getProduto() { return produto; }
    public void setProduto(Estoque produto) { this.produto = produto; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
