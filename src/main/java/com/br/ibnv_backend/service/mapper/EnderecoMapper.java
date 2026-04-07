package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public static Endereco toEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();

        endereco.setId(enderecoDTO.getId());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setPais(enderecoDTO.getPais());
        endereco.setDataCadastro(enderecoDTO.getDataCadastro());

        return endereco;
    }

    public static EnderecoDTO toDto(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setPais(endereco.getPais());
        enderecoDTO.setDataCadastro(endereco.getDataCadastro());

        return enderecoDTO;
    }
}
