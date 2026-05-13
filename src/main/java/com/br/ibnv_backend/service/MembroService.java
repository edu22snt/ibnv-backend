package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Membro;
import com.br.ibnv_backend.repository.MembroRepository;
import com.br.ibnv_backend.service.dto.MembroDTO;
import com.br.ibnv_backend.service.mapper.MembroMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MembroService {

    private final Logger log = LoggerFactory.getLogger(MembroService.class);
    private MembroMapper membroMapper;
    private final MembroRepository pessoaRepository;

    public MembroService(MembroRepository pessoaRepository, MembroMapper membroMapper) {
        this.pessoaRepository = pessoaRepository;
        this.membroMapper = membroMapper;
    }

    public MembroDTO save(MembroDTO dto) {
        log.debug("Request to post save Membro");
        Membro membro = membroMapper.toEntity(dto);
        membro = pessoaRepository.save(membro);
        return membroMapper.toDto(membro);
    }

    @Transactional(readOnly = true)
    public Optional<MembroDTO> findOne(Long id) {
        log.debug("Request to get one Membro by id");
        return pessoaRepository.findById(id).map(MembroMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MembroDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Membro");
        return pessoaRepository.findAll(pageable).map(MembroMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Membro by id : {}", id);
        pessoaRepository.deleteById(id);
    }

    public MembroDTO update(MembroDTO dto) {
        log.debug("Request to update Membro: {}", dto);
        Membro membro = membroMapper.toEntity(dto);
        membro = pessoaRepository.save(membro);
        return membroMapper.toDto(membro);
    }
}
