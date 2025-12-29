package com.example.wmsapi.Model;

import jakarta.persistence.*;


@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String ean;

    @Column(unique = true, nullable = false)
    private String totvs;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEan() { return ean; }
    public void setEan(String ean) { this.ean = ean; }

    public String getTotvs() { return totvs; }
    public void setTotvs(String totvs) { this.totvs = totvs; }
}
