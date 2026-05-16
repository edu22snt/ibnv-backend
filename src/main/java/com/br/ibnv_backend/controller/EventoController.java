package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.EventoService;
import com.br.ibnv_backend.service.dto.EventoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<EventoDTO> save(@RequestBody EventoDTO enderecoDTO) throws URISyntaxException {
        EventoDTO result = service.save(enderecoDTO);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(enderecoDTO);
    }

    @GetMapping("/{id}")
    public Optional<EventoDTO> findById(@PathVariable Long id) {
         Optional<EventoDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping()
    public ResponseEntity<Page<EventoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<EventoDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<EventoDTO> update(@RequestBody EventoDTO dto) {
        EventoDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

}
