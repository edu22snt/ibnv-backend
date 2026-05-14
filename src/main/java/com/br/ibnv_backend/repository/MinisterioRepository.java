package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Ministerio;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MinisterioRepository extends JpaRepository<Ministerio, Long> {

    @Query("SELECT c FROM Ministerio c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.tipo) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.lider) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Ministerio> searchByKeyword(@Param("param") String param, Pageable pageable);
}
