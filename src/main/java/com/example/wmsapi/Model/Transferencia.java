package com.example.wmsapi.Model;

import jakarta.persistence.*;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private int quantidade;
    private String linha;
    private String entreguePara;
    private String data;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getLinha() { return linha; }
    public void setLinha(String linha) { this.linha = linha; }

    public String getEntreguePara() { return entreguePara; }
    public void setEntreguePara(String entreguePara) { this.entreguePara = entreguePara; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
