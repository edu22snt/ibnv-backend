package com.br.ibnv_backend.repository;

import com.br.ibnv_backend.model.Evento;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("SELECT c FROM Evento c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.tipo) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.descricao) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Evento> searchByKeyword(@Param("param") String param, Pageable pageable);
}
