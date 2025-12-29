package com.example.wmsapi.service;

import com.example.wmsapi.Model.Estoque;
import com.example.wmsapi.Model.EstoqueLocal;
import com.example.wmsapi.repository.EstoqueLocalRepository;
import com.example.wmsapi.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueLocalService {

    private final EstoqueLocalRepository localRepository;
    private final EstoqueRepository estoqueRepository;

    public EstoqueLocalService(
            EstoqueLocalRepository localRepository,
            EstoqueRepository estoqueRepository
    ) {
        this.localRepository = localRepository;
        this.estoqueRepository = estoqueRepository;
    }

    public EstoqueLocal adicionar(Long produtoId, String localizacao, int quantidade) {

        Estoque produto = estoqueRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        return localRepository
                .findByProdutoIdAndLocalizacao(produtoId, localizacao)
                .map(local -> {
                    local.setQuantidade(local.getQuantidade() + quantidade);
                    return localRepository.save(local);
                })
                .orElseGet(() -> {
                    EstoqueLocal novo = new EstoqueLocal();
                    novo.setProduto(produto);
                    novo.setLocalizacao(localizacao);
                    novo.setQuantidade(quantidade);
                    return localRepository.save(novo);
                });
    }

    public List<EstoqueLocal> listarPorProduto(Long produtoId) {
        return localRepository.findByProdutoId(produtoId);
    }
}
