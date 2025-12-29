package com.example.wmsapi.repository;

import com.example.wmsapi.Model.EstoqueLocal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
import java.util.Optional;

public interface EstoqueLocalRepository extends JpaRepository<EstoqueLocal, Long> {

    Optional<EstoqueLocal> findByProdutoIdAndLocalizacao(Long produtoId, String localizacao);

    List<EstoqueLocal> findByProdutoId(Long produtoId);
}
