package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Financeiro;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

    @Query("SELECT c FROM Financeiro c WHERE LOWER(c.membro.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.categoria) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.tipo) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Financeiro> searchByKeyword(@Param("param") String param, Pageable pageable);
}
