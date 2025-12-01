package com.example.wmsapi.controller;

import com.example.wmsapi.Model.Estoque;
import com.example.wmsapi.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("*")
public class EstoqueController {

    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {
        return service.salvar(estoque);
    }

    @GetMapping
    public List<Estoque> listar() {
        return service.listar();
    }

    @GetMapping("/{codigo}")
    public Estoque buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PutMapping("/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque novo) {
        return service.atualizar(id, novo);
    }
    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id) {
        return service.deletar(id);
    }

}
