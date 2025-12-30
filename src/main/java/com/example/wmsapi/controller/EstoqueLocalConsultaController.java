package com.example.wmsapi.controller;

import com.example.wmsapi.DTO.EstoqueLocalDTO;
import com.example.wmsapi.DTO.ProdutoComEstoqueDTO;
import com.example.wmsapi.Model.Estoque;
import com.example.wmsapi.repository.EstoqueLocalRepository;
import com.example.wmsapi.repository.EstoqueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque-local")
@CrossOrigin("*")
public class EstoqueLocalConsultaController {

    private final EstoqueRepository estoqueRepo;
    private final EstoqueLocalRepository localRepo;

    public EstoqueLocalConsultaController(
            EstoqueRepository estoqueRepo,
            EstoqueLocalRepository localRepo
    ) {
        this.estoqueRepo = estoqueRepo;
        this.localRepo = localRepo;
    }

    // 🔥 LISTAR ESTOQUE COMPLETO
    @GetMapping
    public List<ProdutoComEstoqueDTO> listarTudo() {

        return estoqueRepo.findAll().stream().map(produto -> {
            ProdutoComEstoqueDTO dto = new ProdutoComEstoqueDTO();
            dto.id = produto.getId();
            dto.nome = produto.getNome();
            dto.ean = produto.getEan();
            dto.totvs = produto.getTotvs();

            dto.locais = localRepo.findByProdutoId(produto.getId())
                    .stream()
                    .map(l -> {
                        EstoqueLocalDTO ld = new EstoqueLocalDTO();
                        ld.localizacao = l.getLocalizacao();
                        ld.quantidade = l.getQuantidade();
                        return ld;
                    }).toList();

            return dto;
        }).toList();
    }

    // 🔥 BUSCAR POR PRODUTO
    @GetMapping("/produto/{codigo}")
    public ProdutoComEstoqueDTO buscarPorCodigo(@PathVariable String codigo) {

        Estoque produto = estoqueRepo.findByEan(codigo)
                .orElse(estoqueRepo.findByTotvs(codigo)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado")));

        ProdutoComEstoqueDTO dto = new ProdutoComEstoqueDTO();
        dto.id = produto.getId();
        dto.nome = produto.getNome();
        dto.ean = produto.getEan();
        dto.totvs = produto.getTotvs();

        dto.locais = localRepo.findByProdutoId(produto.getId())
                .stream()
                .map(l -> {
                    EstoqueLocalDTO ld = new EstoqueLocalDTO();
                    ld.localizacao = l.getLocalizacao();
                    ld.quantidade = l.getQuantidade();
                    return ld;
                }).toList();

        return dto;
    }
}
