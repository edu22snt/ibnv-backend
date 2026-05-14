package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Evento;
import com.br.ibnv_backend.service.dto.EventoDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public static Evento toEntity(EventoDTO dto) {
        Evento entity = new Evento();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setData(dto.getData());
        entity.setTipo(dto.getTipo());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }

    public static EventoDTO toDto(Evento entity) {
        EventoDTO dto = new EventoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setData(entity.getData());
        dto.setTipo(entity.getTipo());
        dto.setDescricao(entity.getDescricao());
        return dto;
    }

}