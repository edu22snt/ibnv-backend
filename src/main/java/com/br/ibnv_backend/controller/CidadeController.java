package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.CidadeService;
import com.br.ibnv_backend.service.dto.CidadeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CidadeDTO> save(@RequestBody CidadeDTO dto) throws URISyntaxException {
        CidadeDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<CidadeDTO> findById(@PathVariable Long id) {
        Optional<CidadeDTO> dto = service.findById(id);
        return dto;
    }

    @GetMapping("/findByEstadoId/{id}")
    public ResponseEntity<List<CidadeDTO>> findByEstadoId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByEstadoId(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<CidadeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<CidadeDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CidadeDTO> update(@RequestBody CidadeDTO dto) {
        CidadeDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findByEstado/{idEstado}")
    public ResponseEntity<List<CidadeDTO>> findByEstado(@PathVariable Long idEstado) {
        List<CidadeDTO> result = service.findByEstado(idEstado);
        return ResponseEntity.ok(result);
    }

}
