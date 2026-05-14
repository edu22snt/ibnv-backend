package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.*;
import com.br.ibnv_backend.service.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    private RelatorioService relatorioService;
    private FinanceiroService financeiroService;
    private MembroService membroService;
    private CelulaService celulaService;
    private EventoService eventoService;
    private MinisterioService ministerioService;

    public RelatorioController(
            RelatorioService relatorioService,
            FinanceiroService financeiroService,
            MembroService membroService,
            CelulaService celulaService,
            EventoService eventoService,
            MinisterioService ministerioService) {
        this.relatorioService = relatorioService;
        this.financeiroService = financeiroService;
        this.membroService = membroService;
        this.celulaService = celulaService;
        this.eventoService = eventoService;
        this.ministerioService = ministerioService;
    }

    @GetMapping("/financeiro")
    public ResponseEntity<byte[]> gerarRelatorioFinanceiro(@RequestParam String param, Pageable pageable) {
        Page<FinanceiroDTO> page = financeiroService.searchByKeyword(param, pageable);
        ByteArrayInputStream pdf = relatorioService.gerarRelatorioFinanceiro(page.getContent(), param);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }

    @GetMapping("/membros")
    public ResponseEntity<byte[]> gerarRelatorioMembros(@RequestParam String param, Pageable pageable) {
        Page<MembroDTO> page = membroService.searchByKeyword(param, pageable);
        ByteArrayInputStream pdf = relatorioService.gerarRelatorioMembros(page.getContent(), param);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }

    @GetMapping("/celula")
    public ResponseEntity<byte[]> gerarRelatorioCelula(@RequestParam String param, Pageable pageable) {
        Page<CelulaDTO> page = celulaService.searchByKeyword(param, pageable);
        ByteArrayInputStream pdf = relatorioService.gerarRelatorioCelula(page.getContent(), param);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }

    @GetMapping("/evento")
    public ResponseEntity<byte[]> gerarRelatorioEvento(@RequestParam String param, Pageable pageable) {
        Page<EventoDTO> page = eventoService.searchByKeyword(param, pageable);
        ByteArrayInputStream pdf = relatorioService.gerarRelatorioEventos(page.getContent(), param);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }

    @GetMapping("/ministerio")
    public ResponseEntity<byte[]> gerarRelatorioMinisterio(@RequestParam String param, Pageable pageable) {
        Page<MinisterioDTO> page = ministerioService.searchByKeyword(param, pageable);
        ByteArrayInputStream pdf = relatorioService.gerarRelatorioMinisterio(page.getContent(), param);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }
}
