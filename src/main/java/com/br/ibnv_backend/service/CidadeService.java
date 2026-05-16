package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Cidade;
import com.br.ibnv_backend.model.Endereco;
import com.br.ibnv_backend.repository.CidadeRepository;
import com.br.ibnv_backend.service.dto.CidadeDTO;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import com.br.ibnv_backend.service.mapper.CidadeMapper;
import com.br.ibnv_backend.service.mapper.EnderecoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final Logger log = LoggerFactory.getLogger(CidadeService.class);
    private final CidadeRepository repository;
    private final CidadeMapper mapper;

    public CidadeService(CidadeRepository repository, CidadeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CidadeDTO save(CidadeDTO dto) {
        log.debug("Request to post save Cidade");
        Cidade entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<CidadeDTO> findById(Long id) {
        log.debug("Request to get find Cidade by id");
        return repository.findById(id).map(CidadeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<CidadeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cidade");
        return repository.findAll(pageable).map(CidadeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<CidadeDTO> findAllNotPage() {
        log.debug("Request to get all Cidade");
        return repository.findAll()
                .stream()
                .map(CidadeMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        log.debug("Request to delete Cidade by id : {}", id);
        repository.deleteById(id);
    }

    public CidadeDTO update(CidadeDTO dto) {
        log.debug("Request to update CidadeDTO: {}", dto);
        Cidade entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public List<CidadeDTO> findByEstado(Long estadoId) {
        return repository.findByEstadoId(estadoId)
                .stream()
                .map(CidadeMapper::toDto)
                .toList();
    }
}
