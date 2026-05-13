package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.FinanceiroService;
import com.br.ibnv_backend.service.dto.FinanceiroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    private final FinanceiroService service;

    public FinanceiroController(FinanceiroService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<FinanceiroDTO> save(@RequestBody FinanceiroDTO dto) throws URISyntaxException {
        FinanceiroDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<FinanceiroDTO> findById(@PathVariable Long id) {
        Optional<FinanceiroDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<FinanceiroDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<FinanceiroDTO> update(@RequestBody FinanceiroDTO dto) {
        FinanceiroDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
