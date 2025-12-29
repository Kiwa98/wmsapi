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

    // ===============================
    // SALVAR (PRODUTO)
    // ===============================
    public Estoque salvar(Estoque estoque) {

        if (repository.existsByEan(estoque.getEan())) {
            throw new IllegalArgumentException("EAN já cadastrado");
        }

        if (repository.existsByTotvs(estoque.getTotvs())) {
            throw new IllegalArgumentException("Código TOTVS já cadastrado");
        }

        return repository.save(estoque);
    }

    // ===============================
    // LISTAR PRODUTOS
    // ===============================
    public List<Estoque> listar() {
        return repository.findAll();
    }

    // ===============================
    // ATUALIZAR PRODUTO
    // ===============================
    public Estoque atualizar(Long id, Estoque novo) {

        Estoque atual = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        if (!atual.getEan().equals(novo.getEan())
                && repository.existsByEan(novo.getEan())) {
            throw new IllegalArgumentException("EAN já cadastrado");
        }

        if (!atual.getTotvs().equals(novo.getTotvs())
                && repository.existsByTotvs(novo.getTotvs())) {
            throw new IllegalArgumentException("Código TOTVS já cadastrado");
        }

        atual.setNome(novo.getNome());
        atual.setEan(novo.getEan());
        atual.setTotvs(novo.getTotvs());

        return repository.save(atual);
    }

    // ===============================
    // DELETAR PRODUTO
    // ===============================
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // ===============================
    // BUSCAR PRODUTO POR EAN OU TOTVS
    // ===============================
    public Estoque buscarPorCodigo(String codigo) {
        return repository.findByEan(codigo)
                .orElse(repository.findByTotvs(codigo).orElse(null));
    }
}
