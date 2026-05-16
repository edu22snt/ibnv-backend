package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Pais;
import com.br.ibnv_backend.service.dto.PaisDTO;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {

    public static Pais toEntity(PaisDTO dto) {
        Pais entity = new Pais();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
        return entity;
    }

    public static PaisDTO toDto(Pais entity) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());

        return dto;
    }
}
