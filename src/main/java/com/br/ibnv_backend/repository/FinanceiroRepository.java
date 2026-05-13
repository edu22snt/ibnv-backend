package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
}
