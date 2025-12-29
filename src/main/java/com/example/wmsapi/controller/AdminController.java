package com.example.wmsapi.controller;

import com.example.wmsapi.repository.EstoqueRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final EstoqueRepository estoqueRepository;

    public AdminController(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @DeleteMapping("/limpar-estoque-invalido")
    public String limparEstoqueInvalido() {

        var lista = estoqueRepository.findAll();

        lista.stream()
                .filter(e -> e.getEan() == null || e.getTotvs() == null)
                .forEach(estoqueRepository::delete);

        return "Registros inválidos removidos com sucesso";
    }
}
