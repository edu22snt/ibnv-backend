package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.repository.EnderecoRepository;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import com.br.ibnv_backend.service.mapper.EnderecoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EnderecoService {

    private final Logger log = LoggerFactory.getLogger(EnderecoService.class);
    private EnderecoMapper enderecoMapper;
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoDTO save(EnderecoDTO enderecoDTO) {
        log.debug("Request to post save Endereco");
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDto(endereco);
    }

    @Transactional(readOnly = true)
    public Optional<EnderecoDTO> findOne(Long id) {
        log.debug("Request to get find Endereco by id");
        return enderecoRepository.findById(id).map(EnderecoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<EnderecoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Endereco");
        return enderecoRepository.findAll(pageable).map(EnderecoMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Endereco by id : {}", id);
        enderecoRepository.deleteById(id);
    }

    public EnderecoDTO update(EnderecoDTO enderecoDTO) {
        log.debug("Request to update Endereco: {}", enderecoDTO);
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDto(endereco);
    }
}
