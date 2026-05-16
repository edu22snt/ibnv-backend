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

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembroService {

    private final Logger log = LoggerFactory.getLogger(MembroService.class);
    private MembroMapper mapper;
    private final MembroRepository repository;

    public MembroService(MembroRepository repository, MembroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MembroDTO save(MembroDTO dto) {
        log.debug("Request to post save Membro");
        Membro membro = mapper.toEntity(dto);
        membro = repository.save(membro);
        return mapper.toDto(membro);
    }

    @Transactional(readOnly = true)
    public Optional<MembroDTO> findOne(Long id) {
        log.debug("Request to get one Membro by id");
        return repository.findById(id).map(MembroMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MembroDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Membro");
        return repository.findAll(pageable).map(MembroMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<MembroDTO> findAllNotPage() {
        log.debug("Request to get all Membro");
        return repository.findAll()
                .stream()
                .map(MembroMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        log.debug("Request to delete Membro by id : {}", id);
        repository.deleteById(id);
    }

    public MembroDTO update(MembroDTO dto) {
        log.debug("Request to update Membro: {}", dto);
        Membro membro = mapper.toEntity(dto);
        membro = repository.save(membro);
        return mapper.toDto(membro);
    }

    @Transactional(readOnly = true)
    public Page<MembroDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Membro by keyword");
        return repository.searchByKeyword(param, pageable).map(MembroMapper::toDto);
    }
}
