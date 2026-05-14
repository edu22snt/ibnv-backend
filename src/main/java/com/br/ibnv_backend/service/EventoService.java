package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.Evento;
import com.br.ibnv_backend.repository.EventoRepository;
import com.br.ibnv_backend.service.dto.EventoDTO;
import com.br.ibnv_backend.service.mapper.EventoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EventoService {

    private final Logger log = LoggerFactory.getLogger(EventoService.class);
    private EventoMapper mapper;
    private final EventoRepository repository;

    public EventoService(EventoMapper mapper, EventoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public EventoDTO save(EventoDTO dto) {
        log.debug("Request to post save Evento");
        Evento entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Optional<EventoDTO> findOne(Long id) {
        log.debug("Request to get one Evento by id");
        return repository.findById(id).map(EventoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<EventoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Evento");
        return repository.findAll(pageable).map(EventoMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Evento by id : {}", id);
        repository.deleteById(id);
    }

    public EventoDTO update(EventoDTO dto) {
        log.debug("Request to update Evento: {}", dto);
        Evento entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public Page<EventoDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Evento by keyword");
        return repository.searchByKeyword(param, pageable).map(EventoMapper::toDto);
    }
}
