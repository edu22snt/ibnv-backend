package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Financeiro;
import com.br.ibnv_backend.repository.FinanceiroRepository;
import com.br.ibnv_backend.service.dto.FinanceiroDTO;
import com.br.ibnv_backend.service.mapper.FinanceiroMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FinanceiroService {

    private final Logger log = LoggerFactory.getLogger(FinanceiroService.class);
    private FinanceiroMapper mapper;
    private final FinanceiroRepository repository;

    public FinanceiroService(FinanceiroMapper mapper, FinanceiroRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public FinanceiroDTO save(FinanceiroDTO dto) {
        log.debug("Request to post save Financeiro");
        Financeiro entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<FinanceiroDTO> findOne(Long id) {
        log.debug("Request to get one Financeiro by id");
        return repository.findById(id).map(FinanceiroMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<FinanceiroDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Financeiro");
        return repository.findAll(pageable).map(FinanceiroMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Financeiro by id : {}", id);
        repository.deleteById(id);
    }

    public FinanceiroDTO update(FinanceiroDTO dto) {
        log.debug("Request to update Financeiro: {}", dto);
        Financeiro entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<FinanceiroDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Financeiro by keyword");
        return repository.searchByKeyword(param, pageable).map(FinanceiroMapper::toDto);
    }
}
