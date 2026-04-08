package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Pessoa;
import com.br.ibnv_backend.service.dto.PessoaDTO;
import org.springframework.stereotype.Component;


@Component
public class PessoaMapper {

    public static Pessoa toEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();

        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setNumTelefone(pessoaDTO.getNumTelefone());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setSexo(pessoaDTO.getSexo());
        pessoa.setEstadoCivil(pessoaDTO.getEstadoCivil());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setAtivo(pessoaDTO.getAtivo());
        return pessoa;
    }

    public static PessoaDTO toDto(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setNumTelefone(pessoa.getNumTelefone());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setSexo(pessoa.getSexo());
        pessoaDTO.setEstadoCivil(pessoa.getEstadoCivil());
        pessoaDTO.setEndereco(pessoa.getEndereco());
        pessoaDTO.setAtivo(pessoa.getAtivo());

        return pessoaDTO;
    }

}