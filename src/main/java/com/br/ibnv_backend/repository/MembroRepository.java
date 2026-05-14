package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Membro;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    @Query("SELECT c FROM Membro c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.email) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.liderDireto) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.estadoCivil) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Membro> searchByKeyword(@Param("param") String param, Pageable pageable);
}
