package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Estado;
import com.br.ibnv_backend.service.dto.EstadoDTO;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper {

    public static Estado toEntity(EstadoDTO dto) {
        Estado entity = new Estado();
        entity.setId(dto.getId());
        return entity;
    }

    public static EstadoDTO toDto(Estado entity) {
        EstadoDTO dto = new EstadoDTO();

        dto.setId(entity.getId());

        return dto;
    }
}
