package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Celula;
import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.service.dto.CelulaDTO;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import org.springframework.stereotype.Component;

@Component
public class CelulaMapper {

    public static Celula toEntity(CelulaDTO dto) {
        Celula entity = new Celula();
        Endereco endereco = new Endereco();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setLider(dto.getLider());
        entity.setEndereco(endereco);
        entity.setDiaSemana(dto.getDiaSemana());
        entity.setHorario(dto.getHorario());
        entity.setAnfitriao(dto.getAnfitriao());
        return entity;
    }

    public static CelulaDTO toDto(Celula entity) {
        CelulaDTO dto = new CelulaDTO();
        EnderecoDTO endereco = new EnderecoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLider(entity.getLider());
        dto.setEndereco(endereco);
        dto.setDiaSemana(entity.getDiaSemana());
        dto.setHorario(entity.getHorario());
        dto.setAnfitriao(entity.getAnfitriao());

        return dto;
    }

}