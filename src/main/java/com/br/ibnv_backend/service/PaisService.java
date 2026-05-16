package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Pais;
import com.br.ibnv_backend.repository.PaisRepository;
import com.br.ibnv_backend.service.dto.PaisDTO;
import com.br.ibnv_backend.service.mapper.PaisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    private final Logger log = LoggerFactory.getLogger(PaisService.class);
    private final PaisRepository repository;
    private final PaisMapper mapper;

    public PaisService(PaisRepository repository, PaisMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PaisDTO save(PaisDTO dto) {
        log.debug("Request to post save Pais");
        Pais entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<PaisDTO> findById(Long id) {
        log.debug("Request to get find Pais by id");
        return repository.findById(id).map(PaisMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<PaisDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pais");
        return repository.findAll(pageable).map(PaisMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<PaisDTO> findAllNotPage() {
        log.debug("Request to get all Pais");
        return repository.findAll()
                .stream()
                .map(PaisMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        log.debug("Request to delete Pais by id : {}", id);
        repository.deleteById(id);
    }

    public PaisDTO update(PaisDTO dto) {
        log.debug("Request to update Estado: {}", dto);
        Pais entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

}
