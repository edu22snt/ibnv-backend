package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.CelulaService;
import com.br.ibnv_backend.service.dto.CelulaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(name="/api/celula")
public class CelulaController {

    private final CelulaService service;

    public CelulaController(CelulaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CelulaDTO> save(@RequestBody CelulaDTO dto) throws URISyntaxException {
        CelulaDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<CelulaDTO> findById(@PathVariable Long id) {
        Optional<CelulaDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<CelulaDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CelulaDTO> update(@RequestBody CelulaDTO dto) {
        CelulaDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
