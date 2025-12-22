package com.example.wmsapi.repository;

import com.example.wmsapi.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Optional<Estoque> findByEan(String ean);

    Optional<Estoque> findByTotvs(String totvs);

    boolean existsByEan(String ean);

    boolean existsByTotvs(String totvs);
}
