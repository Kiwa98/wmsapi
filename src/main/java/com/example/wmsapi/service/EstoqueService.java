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
    // SALVAR (COM VALIDAÇÃO)
    // ===============================
    public Estoque salvar(Estoque estoque) {

        // valida EAN duplicado
        if (repository.existsByEan(estoque.getEan())) {
            throw new IllegalArgumentException("EAN já cadastrado");
        }

        // valida TOTVS duplicado
        if (repository.existsByTotvs(estoque.getTotvs())) {
            throw new IllegalArgumentException("Código TOTVS já cadastrado");
        }

        return repository.save(estoque);
    }

    // ===============================
    // LISTAR
    // ===============================
    public List<Estoque> listar() {
        return repository.findAll();
    }

    // ===============================
    // ATUALIZAR (COM VALIDAÇÃO)
    // ===============================
    public Estoque atualizar(Long id, Estoque novo) {

        Estoque atual = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        // se mudou o EAN, valida duplicidade
        if (!atual.getEan().equals(novo.getEan())
                && repository.existsByEan(novo.getEan())) {
            throw new IllegalArgumentException("EAN já cadastrado");
        }

        // se mudou o TOTVS, valida duplicidade
        if (!atual.getTotvs().equals(novo.getTotvs())
                && repository.existsByTotvs(novo.getTotvs())) {
            throw new IllegalArgumentException("Código TOTVS já cadastrado");
        }

        atual.setNome(novo.getNome());
        atual.setEan(novo.getEan());
        atual.setTotvs(novo.getTotvs());
        atual.setQuantidade(novo.getQuantidade());
        atual.setLocalizacao(novo.getLocalizacao());

        return repository.save(atual);
    }

    // ===============================
    // DELETAR
    // ===============================
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // ===============================
    // BUSCAR POR EAN OU TOTVS
    // ===============================
    public Estoque buscarPorCodigo(String codigo) {
        return repository.findByEan(codigo)
                .orElse(repository.findByTotvs(codigo).orElse(null));
    }
}
