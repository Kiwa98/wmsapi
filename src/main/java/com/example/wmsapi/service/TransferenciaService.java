package com.example.wmsapi.service;

import com.example.wmsapi.Model.Transferencia;
import com.example.wmsapi.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public TransferenciaService(TransferenciaRepository repository) {
        this.repository = repository;
    }

    public Transferencia salvar(Transferencia t) {
        return repository.save(t);
    }

    public List<Transferencia> listar() {
        return repository.findAll();
    }
}
