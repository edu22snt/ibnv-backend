package com.br.ibnv_backend.service.mapper;

import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.model.Financeiro;
import com.br.ibnv_backend.model.Membro;
import com.br.ibnv_backend.model.NotaFiscal;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import com.br.ibnv_backend.service.dto.FinanceiroDTO;
import com.br.ibnv_backend.service.dto.MembroDTO;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import org.springframework.stereotype.Component;

@Component
public class FinanceiroMapper {

    public static Financeiro toEntity(FinanceiroDTO dto) {
        Financeiro entity = new Financeiro();
        Membro membro = new Membro();
        Endereco endereco = new Endereco();
        NotaFiscal notaFiscal = new NotaFiscal();

        membro.setId(dto.getMembro().getId());
        membro.setNome(dto.getMembro().getNome());
        membro.setLider(dto.getMembro().isLider());
        membro.setEmail(dto.getMembro().getEmail());
        membro.setNumTelefone(dto.getMembro().getNumTelefone());
        membro.setDataNascimento(dto.getMembro().getDataNascimento());
        membro.setSexo(dto.getMembro().getSexo());
        membro.setEstadoCivil(dto.getMembro().getEstadoCivil());
        membro.setEndereco(endereco);
        membro.setAtivo(dto.getMembro().getAtivo());
        membro.setDataCadastro(dto.getMembro().getDataCadastro());
        membro.setDataBatismo(dto.getMembro().getDataBatismo());

        notaFiscal.setId(dto.getNotaFiscal().getId());
        notaFiscal.setNomeArquivo(dto.getNotaFiscal().getNomeArquivo());
        notaFiscal.setTipoArquivo(dto.getNotaFiscal().getTipoArquivo());
        notaFiscal.setImagem(dto.getNotaFiscal().getImagem());

        entity.setId(dto.getId());
        entity.setTipo(dto.getTipo());
        entity.setCategoria(dto.getCategoria());
        entity.setValor(dto.getValor());
        entity.setData(dto.getData());
        entity.setDescricao(dto.getDescricao());
        entity.setMembro(membro);
        entity.setNotaFiscal(notaFiscal);
        return entity;
    }

    public static FinanceiroDTO toDto(Financeiro entity) {
        FinanceiroDTO dto = new FinanceiroDTO();
        MembroDTO membro = new MembroDTO();
        EnderecoDTO endereco = new EnderecoDTO();
        NotaFiscalDTO notaFiscal = new NotaFiscalDTO();

        membro.setId(entity.getMembro().getId());
        membro.setNome(entity.getMembro().getNome());
        membro.setLider(entity.getMembro().isLider());
        membro.setEmail(entity.getMembro().getEmail());
        membro.setNumTelefone(entity.getMembro().getNumTelefone());
        membro.setDataNascimento(entity.getMembro().getDataNascimento());
        membro.setSexo(entity.getMembro().getSexo());
        membro.setEstadoCivil(entity.getMembro().getEstadoCivil());
        membro.setEndereco(endereco);
        membro.setAtivo(entity.getMembro().getAtivo());
        membro.setDataCadastro(entity.getMembro().getDataCadastro());
        membro.setDataBatismo(entity.getMembro().getDataBatismo());


        notaFiscal.setId(entity.getNotaFiscal().getId());
        notaFiscal.setNomeArquivo(entity.getNotaFiscal().getNomeArquivo());
        notaFiscal.setTipoArquivo(entity.getNotaFiscal().getTipoArquivo());
        notaFiscal.setImagem(entity.getNotaFiscal().getImagem());

        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo());
        dto.setCategoria(entity.getCategoria());
        dto.setValor(entity.getValor());
        dto.setData(entity.getData());
        dto.setDescricao(entity.getDescricao());
        dto.setMembro(membro);
        dto.setNotaFiscal(notaFiscal);
        return dto;
    }

}