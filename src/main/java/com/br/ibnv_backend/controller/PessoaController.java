package com.br.ibnv_backend.controller;

import com.br.ibnv_backend.service.PessoaService;
import com.br.ibnv_backend.service.dto.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO) throws URISyntaxException {
        PessoaDTO result = service.save(pessoaDTO);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(pessoaDTO);
    }

    @GetMapping("/{id}")
    public Optional<PessoaDTO> findById(@PathVariable Long id) {
         Optional<PessoaDTO> pessoaDTO = service.findOne(id);
        return pessoaDTO;
    }

    @GetMapping()
    public ResponseEntity<Page<PessoaDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PessoaDTO> update(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO result = service.update(pessoaDTO);
        return ResponseEntity.ok().body(result);
    }

}
