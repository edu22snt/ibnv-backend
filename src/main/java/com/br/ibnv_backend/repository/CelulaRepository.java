package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Celula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {
}
