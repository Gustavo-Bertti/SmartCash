package br.com.fiap.smartcash.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.smartcash.model.FluxoDeCaixa;
import br.com.fiap.smartcash.repository.FluxoDeCaixaRepository;

@RestController
@RequestMapping("/fluxodecaixa")
public class FluxoDeCaixaController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    FluxoDeCaixaRepository repository;

    @GetMapping
    public List<FluxoDeCaixa> index() {
        return repository.findAll();
    }

    // @PostMapping
    // public ResponseEntity<FluxoDeCaixa> create(@RequestBody FluxoDeCaixa fluxoDeCaixa) {
    //     log.info("cadastrando categoria: {},", fluxoDeCaixa);
    //     fluxoLista.add(fluxoDeCaixa);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(fluxoDeCaixa);
    // }

    // @GetMapping(path = "{id}")
    // public ResponseEntity<FluxoDeCaixa> get(@PathVariable Long id) {
    //     log.info("buscando categoria com id {}", id);

    //     // stream
    //     var fluxodecaixa = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();

    //     log.info("categoria encontrada: {}", fluxodecaixa);

    //     if (fluxodecaixa == null) {
    //         return ResponseEntity.status(404).build();
    //     }
    //      return ResponseEntity.ok().body(fluxodecaixa.get());
    // }

    // @PutMapping(path = "{id}")
    // public ResponseEntity<FluxoDeCaixa> put(@PathVariable Long id, @RequestBody FluxoDeCaixa fluxoDeCaixa) {
    //     log.info("buscando categoria com id {}", id);

    //     // stream
    //     var fluxoencontrado = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();
    //     FluxoDeCaixa fluxoAtualizado = new FluxoDeCaixa(fluxoencontrado.get().id(), fluxoDeCaixa.tipo(),
    //             fluxoDeCaixa.valor(), fluxoDeCaixa.descricao(), fluxoDeCaixa.data());
    //     fluxoLista.remove(fluxoencontrado.get());
    //     fluxoLista.add(fluxoAtualizado);

    //     log.info("categoria encontrada e alterado: {}", fluxoAtualizado);

    //     if (fluxoencontrado == null){
    //         return ResponseEntity.status(404).build();
    //     }
    //     return ResponseEntity.ok().body(fluxoAtualizado);
    // }
    // @DeleteMapping(path = "{id}")
    // public ResponseEntity<FluxoDeCaixa> remove(@PathVariable Long id, @RequestBody FluxoDeCaixa fluxoDeCaixa) {
    //     log.info("buscando categoria com id {}", id);

    //     var fluxoEncontrado = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();

    //     if (fluxoEncontrado.isEmpty()) {
    //         log.info("Fluxo de caixa com ID {} não encontrado", id);
    //         return ResponseEntity.status(404).build();
    //     }

    //     fluxoLista.remove(fluxoEncontrado.get());
    //     return ResponseEntity.noContent().body(fluxoEncontrado.get());

    // }
}
