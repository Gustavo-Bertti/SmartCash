package br.com.fiap.smartcash.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.smartcash.model.FluxoDeCaixa;
import br.com.fiap.smartcash.repository.FluxoDeCaixaRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fluxodecaixa")
@Slf4j
public class FluxoDeCaixaController {

    
    @Autowired
    FluxoDeCaixaRepository repository;

    @GetMapping
    public List<FluxoDeCaixa> getAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public FluxoDeCaixa create(@RequestBody FluxoDeCaixa fluxoDeCaixa) {
        log.info("cadastrando fluxo de caixa: {},", fluxoDeCaixa);
        return repository.save(fluxoDeCaixa);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<FluxoDeCaixa> get(@PathVariable Long id) {
        log.info("buscando fluxo de caixa com id {}", id);

        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "{id}")
    public FluxoDeCaixa update(@PathVariable Long id, @RequestBody FluxoDeCaixa fluxoDeCaixa) {
        log.info("buscando fluxo de caixa com id {}", id);
        verificarSeExisteCategoria(id);
        fluxoDeCaixa.setId(id);
        repository.save(fluxoDeCaixa);
        return fluxoDeCaixa;
       
    }
    @DeleteMapping(path = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void remove(@PathVariable Long id) {
        log.info("buscando fluxo de caixa com id {}", id);
        verificarSeExisteCategoria(id);
        repository.deleteById(id);
       
    }

    private void verificarSeExisteCategoria(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "id da categoria não encontrado"));
    }
}
