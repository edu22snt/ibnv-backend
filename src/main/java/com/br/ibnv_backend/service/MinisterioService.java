package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Ministerio;
import com.br.ibnv_backend.repository.MinisterioRepository;
import com.br.ibnv_backend.service.dto.MinisterioDTO;
import com.br.ibnv_backend.service.mapper.MinisterioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MinisterioService {

    private final Logger log = LoggerFactory.getLogger(MinisterioService.class);
    private MinisterioMapper mapper;
    private final MinisterioRepository repository;

    public MinisterioService(MinisterioMapper mapper, MinisterioRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public MinisterioDTO save(MinisterioDTO dto) {
        log.debug("Request to post save Ministerio");
        Ministerio entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<MinisterioDTO> findOne(Long id) {
        log.debug("Request to get one Ministerio by id");
        return repository.findById(id).map(MinisterioMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MinisterioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Ministerio");
        return repository.findAll(pageable).map(MinisterioMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Evento by id : {}", id);
        repository.deleteById(id);
    }

    public MinisterioDTO update(MinisterioDTO dto) {
        log.debug("Request to update Ministerio: {}", dto);
        Ministerio entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<MinisterioDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Ministerio by keyword");
        return repository.searchByKeyword(param, pageable).map(MinisterioMapper::toDto);
    }
}
