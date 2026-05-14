package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Evento;
import com.br.ibnv_backend.model.EventoParticipantes;
import com.br.ibnv_backend.service.dto.EventoDTO;
import com.br.ibnv_backend.service.dto.EventoParticipantesDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoParticipantesMapper {

    public static EventoParticipantes toEntity(EventoParticipantesDTO dto) {
        EventoParticipantes entity = new EventoParticipantes();
        Evento evento = new Evento();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setNumTelefone(dto.getNumTelefone());
        entity.setEvento(evento);
        return entity;
    }

    public static EventoParticipantesDTO toDto(EventoParticipantes entity) {
        EventoParticipantesDTO dto = new EventoParticipantesDTO();
        EventoDTO evento = new EventoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setNumTelefone(entity.getNumTelefone());
        dto.setEvento(evento);
        return dto;
    }

}