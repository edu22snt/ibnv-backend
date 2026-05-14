package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.MinisterioService;
import com.br.ibnv_backend.service.dto.MinisterioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/api/ministerio")
public class MinisterioController {

    private final MinisterioService service;

    public MinisterioController(MinisterioService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<MinisterioDTO> save(@RequestBody MinisterioDTO dto) throws URISyntaxException {
        MinisterioDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<MinisterioDTO> findById(@PathVariable Long id) {
         Optional<MinisterioDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<MinisterioDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<MinisterioDTO> update(@RequestBody MinisterioDTO dto) {
        MinisterioDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

}
