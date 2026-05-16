package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.MembroService;
import com.br.ibnv_backend.service.dto.MembroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/membro")
public class MembroController {

    private final MembroService service;

    public MembroController(MembroService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<MembroDTO> save(@RequestBody MembroDTO dto) throws URISyntaxException {
        MembroDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<MembroDTO> findById(@PathVariable Long id) {
         Optional<MembroDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<MembroDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<MembroDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<MembroDTO> update(@RequestBody MembroDTO dto) {
        MembroDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

}
