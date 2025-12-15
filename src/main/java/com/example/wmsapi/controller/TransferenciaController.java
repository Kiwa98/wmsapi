package com.example.wmsapi.controller;

import com.example.wmsapi.Model.Transferencia;
import com.example.wmsapi.service.TransferenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
@CrossOrigin("*")
public class TransferenciaController {

    private final TransferenciaService service;

    public TransferenciaController(TransferenciaService service) {
        this.service = service;
    }

    @PostMapping
    public Transferencia salvar(@RequestBody Transferencia t) {
        return service.salvar(t);
    }

    @GetMapping
    public List<Transferencia> listar() {
        return service.listar();
    }
}
