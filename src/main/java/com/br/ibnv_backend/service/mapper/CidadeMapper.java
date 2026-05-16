package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Cidade;
import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.model.Estado;
import com.br.ibnv_backend.model.Pais;
import com.br.ibnv_backend.service.dto.CidadeDTO;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import com.br.ibnv_backend.service.dto.EstadoDTO;
import com.br.ibnv_backend.service.dto.PaisDTO;
import org.springframework.stereotype.Component;

@Component
public class CidadeMapper {

    public static Cidade toEntity(CidadeDTO dto) {
        Cidade entity = new Cidade();
        Estado estado = new Estado();
        Pais pais = new Pais();

        pais.setId(dto.getId());
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getEstado().getSigla());

        estado.setId(dto.getId());
        estado.setNome(dto.getNome());
        estado.setPais(pais);

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEstado(estado);
        return entity;
    }

    public static CidadeDTO toDto(Cidade entity) {
        CidadeDTO dto = new CidadeDTO();
        EstadoDTO estado = new EstadoDTO();
        PaisDTO pais = new PaisDTO();

        pais.setId(entity.getId());
        pais.setNome(entity.getNome());
        pais.setSigla(entity.getEstado().getSigla());

        estado.setId(entity.getId());
        estado.setNome(entity.getNome());
        estado.setPais(pais);

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEstado(estado);

        return dto;
    }
}
