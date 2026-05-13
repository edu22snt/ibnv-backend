package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.model.Membro;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import com.br.ibnv_backend.service.dto.MembroDTO;
import org.springframework.stereotype.Component;

@Component
public class MembroMapper {

    public static Membro toEntity(MembroDTO dto) {
        Membro entity = new Membro();
        Endereco endereco = new Endereco();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setLider(dto.isLider());
        entity.setEmail(dto.getEmail());
        entity.setNumTelefone(dto.getNumTelefone());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setEstadoCivil(dto.getEstadoCivil());
        entity.setEndereco(endereco);
        entity.setAtivo(dto.getAtivo());
        entity.setDataCadastro(dto.getDataCadastro());
        entity.setDataBatismo(dto.getDataBatismo());
        return entity;
    }

    public static MembroDTO toDto(Membro entity) {
        MembroDTO dto = new MembroDTO();
        EnderecoDTO endereco = new EnderecoDTO();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLider(entity.isLider());
        dto.setEmail(entity.getEmail());
        dto.setNumTelefone(entity.getNumTelefone());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setSexo(entity.getSexo());
        dto.setEstadoCivil(entity.getEstadoCivil());
        dto.setEndereco(endereco);
        dto.setAtivo(entity.getAtivo());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setDataBatismo(entity.getDataBatismo());

        return dto;
    }

}