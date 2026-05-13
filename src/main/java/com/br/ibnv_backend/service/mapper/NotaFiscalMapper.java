package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.NotaFiscal;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import org.springframework.stereotype.Component;


@Component
public class NotaFiscalMapper {

    public static NotaFiscal toEntity(NotaFiscalDTO dto) {
        NotaFiscal entity = new NotaFiscal();

        entity.setId(dto.getId());
        entity.setNomeArquivo(dto.getNomeArquivo());
        entity.setTipoArquivo(dto.getTipoArquivo());
        entity.setImagem(dto.getImagem());
        return entity;
    }

    public static NotaFiscalDTO toDto(NotaFiscal entity) {
        NotaFiscalDTO dto = new NotaFiscalDTO();

        dto.setId(entity.getId());
        dto.setNomeArquivo(entity.getNomeArquivo());
        dto.setTipoArquivo(entity.getTipoArquivo());
        dto.setImagem(entity.getImagem());
        return dto;
    }

}