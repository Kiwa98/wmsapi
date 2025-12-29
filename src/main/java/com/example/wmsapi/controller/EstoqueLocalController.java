package com.example.wmsapi.controller;

import com.example.wmsapi.DTO.EstoqueLocalRequest;
import com.example.wmsapi.service.EstoqueLocalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque-local")
@CrossOrigin("*")
public class EstoqueLocalController {

    private final EstoqueLocalService service;

    public EstoqueLocalController(EstoqueLocalService service) {
        this.service = service;
    }

    @PostMapping("/{produtoId}")
    public ResponseEntity<?> adicionar(
            @PathVariable Long produtoId,
            @RequestBody EstoqueLocalRequest req
    ) {
        try {
            return ResponseEntity.ok(
                    service.adicionar(produtoId, req.getLocalizacao(), req.getQuantidade())
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
