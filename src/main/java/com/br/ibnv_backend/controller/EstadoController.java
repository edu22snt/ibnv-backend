package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.EstadoService;
import com.br.ibnv_backend.service.dto.EstadoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<EstadoDTO> save(@RequestBody EstadoDTO dto) throws URISyntaxException {
        EstadoDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/{id}")
    public Optional<EstadoDTO> findById(@PathVariable Long id) {
        Optional<EstadoDTO> dto = service.findById(id);
        return dto;
    }

    @GetMapping("/findByPaisId/{id}")
    public ResponseEntity<List<EstadoDTO>> findByPaisId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByPaisId(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<EstadoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<EstadoDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<EstadoDTO> update(@RequestBody EstadoDTO dto) {
        EstadoDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findByEstado/{idPais}")
    public ResponseEntity<List<EstadoDTO>> findByEstado(@PathVariable Long idPais) {
        List<EstadoDTO> result = service.findByPais(idPais);
        return ResponseEntity.ok(result);
    }

}
