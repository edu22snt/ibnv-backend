package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Membro;
import com.br.ibnv_backend.model.Ministerio;
import com.br.ibnv_backend.service.dto.MembroDTO;
import com.br.ibnv_backend.service.dto.MinisterioDTO;
import org.springframework.stereotype.Component;

@Component
public class MinisterioMapper {

    public static Ministerio toEntity(MinisterioDTO dto) {
        Ministerio entity = new Ministerio();
        Membro lider = new Membro();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setLider(lider);

        return entity;
    }

    public static MinisterioDTO toDto(Ministerio entity) {
        MinisterioDTO dto = new MinisterioDTO();
        MembroDTO lider = new MembroDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLider(lider);
        return dto;
    }

}