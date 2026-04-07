package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.EnderecoService;
import com.br.ibnv_backend.service.dto.EnderecoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) throws URISyntaxException {
        EnderecoDTO result = service.save(enderecoDTO);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(enderecoDTO);
    }

    @GetMapping("/{id}")
    public Optional<EnderecoDTO> findById(@PathVariable Long id) {
         Optional<EnderecoDTO> enderecoDTO = service.findOne(id);
        return enderecoDTO;
    }

    @GetMapping()
    public ResponseEntity<Page<EnderecoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO result = service.update(enderecoDTO);
        return ResponseEntity.ok().body(result);
    }

}
