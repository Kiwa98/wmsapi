package com.example.wmsapi.controller;

import com.example.wmsapi.Model.Estoque;
import com.example.wmsapi.repository.EstoqueRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final EstoqueRepository estoqueRepository;

    public AdminController(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @GetMapping("/limpar-estoque-invalido")
    public String limparEstoqueInvalido() {

        int removidos = 0;

        for (Estoque e : estoqueRepository.findAll()) {

            boolean invalido =
                    e.getNome() == null ||
                            e.getEan() == null ||
                            e.getTotvs() == null;

            if (invalido) {
                estoqueRepository.delete(e);
                removidos++;
            }
        }

        return "Registros inválidos removidos: " + removidos;
    }

}
