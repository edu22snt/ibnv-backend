package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.NotaFiscal;
import com.br.ibnv_backend.repository.NotaFiscalRepository;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import com.br.ibnv_backend.service.mapper.NotaFiscalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UploadService {

    private final Logger log = LoggerFactory.getLogger(UploadService.class);
    private final NotaFiscalRepository notaFiscalRepository;
    private final NotaFiscalMapper notaFiscalMapper;

    public UploadService(NotaFiscalRepository notaFiscalRepository, NotaFiscalMapper notaFiscalMapper) {
        this.notaFiscalRepository = notaFiscalRepository;
        this.notaFiscalMapper = notaFiscalMapper;
    }

    public NotaFiscalDTO save(NotaFiscalDTO dto) {
        log.debug("Request to post save NotaFiscal");
        NotaFiscal notaFiscal = notaFiscalMapper.toEntity(dto);
        notaFiscal = notaFiscalRepository.save(notaFiscal);
        return notaFiscalMapper.toDto(notaFiscal);
    }

    @Transactional(readOnly = true)
    public Optional<NotaFiscalDTO> findById(Long id) {
        log.debug("Request to get find NotaFiscal by id");
        return notaFiscalRepository.findById(id).map(NotaFiscalMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<NotaFiscalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NotaFiscal");
        return notaFiscalRepository.findAll(pageable).map(NotaFiscalMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete NotaFiscal by id : {}", id);
        notaFiscalRepository.deleteById(id);
    }

    public NotaFiscalDTO update(NotaFiscalDTO dto) {
        log.debug("Request to update NotaFiscal: {}", dto);
        NotaFiscal notaFiscal = notaFiscalMapper.toEntity(dto);
        notaFiscal = notaFiscalRepository.save(notaFiscal);
        return notaFiscalMapper.toDto(notaFiscal);
    }
}
