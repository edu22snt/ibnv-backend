package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Pessoa;
import com.br.ibnv_backend.repository.PessoaRepository;
import com.br.ibnv_backend.service.dto.PessoaDTO;
import com.br.ibnv_backend.service.mapper.PessoaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PessoaService {

    private final Logger log = LoggerFactory.getLogger(PessoaService.class);
    private PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {
        log.debug("Request to post save Pessoas");
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDto(pessoa);
    }

    @Transactional(readOnly = true)
    public Optional<PessoaDTO> findOne(Long id) {
        log.debug("Request to get one Pessoas by id");
        return pessoaRepository.findById(id).map(PessoaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pessoas");
        return pessoaRepository.findAll(pageable).map(PessoaMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Pessoa by id : {}", id);
        pessoaRepository.deleteById(id);
    }

    public PessoaDTO update(PessoaDTO pessoaDTO) {
        log.debug("Request to update pessoa: {}", pessoaDTO);
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDto(pessoa);
    }
}
