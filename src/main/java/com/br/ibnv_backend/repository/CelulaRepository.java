package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Celula;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {

    @Query("SELECT c FROM Celula c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.endereco) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.diaSemana) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.horario) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.lider) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Celula> searchByKeyword(@Param("param") String param, Pageable pageable);
}
