package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.UploadService;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService service;

    public UploadController(UploadService service) {
        this.service = service;
    }

    @PostMapping("/notaFiscal")
    public ResponseEntity<?> upload(@RequestParam("arquivo") MultipartFile arquivo) throws IOException {
        NotaFiscalDTO nota = new NotaFiscalDTO();
        nota.setNomeArquivo(arquivo.getOriginalFilename());
        nota.setTipoArquivo(arquivo.getContentType());
        nota.setImagem(arquivo.getBytes());
        service.save(nota);
        return ResponseEntity.ok("Arquivo enviado");
    }
}
