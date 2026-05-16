package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Cidade;
import com.br.ibnv_backend.model.Estado;
import com.br.ibnv_backend.repository.CidadeRepository;
import com.br.ibnv_backend.repository.EstadoRepository;
import com.br.ibnv_backend.service.dto.CidadeDTO;
import com.br.ibnv_backend.service.dto.EstadoDTO;
import com.br.ibnv_backend.service.mapper.CidadeMapper;
import com.br.ibnv_backend.service.mapper.EstadoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final Logger log = LoggerFactory.getLogger(EstadoService.class);
    private final EstadoRepository repository;
    private final EstadoMapper mapper;

    public EstadoService(EstadoRepository repository, EstadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EstadoDTO save(EstadoDTO dto) {
        log.debug("Request to post save Estado");
        Estado entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<EstadoDTO> findById(Long id) {
        log.debug("Request to get find Estado by id");
        return repository.findById(id).map(EstadoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<EstadoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Estado");
        return repository.findAll(pageable).map(EstadoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<EstadoDTO> findAllNotPage() {
        log.debug("Request to get all Estado");
        return repository.findAll()
                .stream()
                .map(EstadoMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        log.debug("Request to delete Cidade by id : {}", id);
        repository.deleteById(id);
    }

    public EstadoDTO update(EstadoDTO dto) {
        log.debug("Request to update Estado: {}", dto);
        Estado entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public List<EstadoDTO> findByPais(Long paisId) {
        return repository.findByPaisId(paisId)
                .stream()
                .map(EstadoMapper::toDto)
                .toList();
    }
}
