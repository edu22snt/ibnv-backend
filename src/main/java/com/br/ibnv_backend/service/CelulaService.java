package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Celula;
import com.br.ibnv_backend.repository.CelulaRepository;
import com.br.ibnv_backend.service.dto.CelulaDTO;
import com.br.ibnv_backend.service.mapper.CelulaMapper;
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
public class CelulaService {

    private final Logger log = LoggerFactory.getLogger(CelulaService.class);
    private final CelulaRepository repository;
    private final CelulaMapper mapper;


    public CelulaService(CelulaRepository repository, CelulaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CelulaDTO save(CelulaDTO dto) {
        log.debug("Request to post save Celula");
        Celula celula = mapper.toEntity(dto);
        celula = repository.save(celula);
        return mapper.toDto(celula);
    }

    @Transactional(readOnly = true)
    public Optional<CelulaDTO> findOne(Long id) {
        log.debug("Request to get find Celula by id");
        return repository.findById(id).map(CelulaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<CelulaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Celula");
        return repository.findAll(pageable).map(CelulaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<CelulaDTO> findAllNotPage() {
        log.debug("Request to get all Celula");
        return repository.findAll()
                .stream()
                .map(CelulaMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        log.debug("Request to delete Celula by id : {}", id);
        repository.deleteById(id);
    }

    public CelulaDTO update(CelulaDTO dto) {
        log.debug("Request to update Celula: {}", dto);
        Celula celula = mapper.toEntity(dto);
        celula = repository.save(celula);
        return mapper.toDto(celula);
    }

    @Transactional(readOnly = true)
    public Page<CelulaDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Celula by keyword");
        return repository.searchByKeyword(param, pageable).map(CelulaMapper::toDto);
    }
}
