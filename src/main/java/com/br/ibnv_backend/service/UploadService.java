package com.br.ibnv_backend.service;

import com.br.ibnv_backend.model.NotaFiscal;
import com.br.ibnv_backend.repository.NotaFiscalRepository;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import com.br.ibnv_backend.service.mapper.NotaFiscalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
