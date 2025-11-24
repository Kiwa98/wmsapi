package com.example.wmsapi.service;

import com.example.wmsapi.Model.Estoque;
import com.example.wmsapi.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    public Estoque salvar(Estoque estoque) {
        return repository.save(estoque);
    }

    public List<Estoque> listar() {
        return repository.findAll();
    }

    public Estoque atualizar(Long id, Estoque novo) {
        return repository.findById(id).map(e -> {
            e.setNome(novo.getNome());
            e.setEan(novo.getEan());
            e.setTotvs(novo.getTotvs());
            e.setQuantidade(novo.getQuantidade());
            e.setLocalizacao(novo.getLocalizacao());
            return repository.save(e);
        }).orElse(null);
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Estoque buscarPorCodigo(String codigo) {
        return repository.findByEan(codigo)
                .orElse(repository.findByTotvs(codigo).orElse(null));
    }
}
