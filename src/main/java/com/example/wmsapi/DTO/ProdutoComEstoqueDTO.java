package com.example.wmsapi.DTO;

import java.util.List;

public class ProdutoComEstoqueDTO {
    public Long id;
    public String nome;
    public String ean;
    public String totvs;
    public List<EstoqueLocalDTO> locais;
}
