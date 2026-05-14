package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.UploadService;
import com.br.ibnv_backend.service.dto.NotaFiscalDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService service;

    @Value("${app.upload.dir}")
    private String uploadDir;

    public UploadController(UploadService service) {
        this.service = service;
    }

    @PostMapping("/notaFiscal/{id}/imagem")
    public ResponseEntity<?> uploadImagem(@PathVariable Long id,@RequestParam("arquivo") MultipartFile arquivo) throws IOException {
        String nomeArquivo = UUID.randomUUID() + "_" + arquivo.getOriginalFilename();
        Path caminho = Paths.get(uploadDir, nomeArquivo);
        Files.createDirectories(caminho.getParent());
        Files.write(caminho, arquivo.getBytes());
        NotaFiscalDTO nota = service.findById(id).orElseThrow();
        nota.setCaminhoImagem(nomeArquivo);
        service.save(nota);
        return ResponseEntity.ok().build();
    }
}
