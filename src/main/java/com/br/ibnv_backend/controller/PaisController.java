package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.PaisService;
import com.br.ibnv_backend.service.dto.PaisDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/pais")
public class PaisController {

    private final PaisService service;

    public PaisController(PaisService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO dto) throws URISyntaxException {
        PaisDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<PaisDTO> findById(@PathVariable Long id) {
        Optional<PaisDTO> dto = service.findById(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<PaisDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<PaisDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PaisDTO> update(@RequestBody PaisDTO dto) {
        PaisDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

}