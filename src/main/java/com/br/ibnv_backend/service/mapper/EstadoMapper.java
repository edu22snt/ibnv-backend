package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Estado;
import com.br.ibnv_backend.model.Pais;
import com.br.ibnv_backend.service.dto.EstadoDTO;
import com.br.ibnv_backend.service.dto.PaisDTO;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper {

    public static Estado toEntity(EstadoDTO dto) {
        Estado entity = new Estado();
        Pais pais = new Pais();

        pais.setId(dto.getId());
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
        entity.setPais(pais);
        return entity;
    }

    public static EstadoDTO toDto(Estado entity) {
        EstadoDTO dto = new EstadoDTO();
        PaisDTO pais = new PaisDTO();

        pais.setId(dto.getId());
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());
        dto.setPais(pais);
        return dto;
    }
}
