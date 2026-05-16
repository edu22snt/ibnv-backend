package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Cidade;
import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.service.dto.CidadeDTO;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import org.springframework.stereotype.Component;

@Component
public class CidadeMapper {

    public static Cidade toEntity(CidadeDTO dto) {
        Cidade entity = new Cidade();
        entity.setId(dto.getId());
        return entity;
    }

    public static CidadeDTO toDto(Cidade entity) {
        CidadeDTO dto = new CidadeDTO();

        dto.setId(entity.getId());

        return dto;
    }
}
