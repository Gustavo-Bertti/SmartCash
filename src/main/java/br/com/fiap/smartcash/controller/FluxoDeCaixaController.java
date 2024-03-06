package br.com.fiap.smartcash.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.smartcash.model.FluxoDeCaixa;

@Controller
public class FluxoDeCaixaController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<FluxoDeCaixa> fluxoLista = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path = "/fluxodecaixa")
    @ResponseBody
    public List<FluxoDeCaixa> index() {
        return fluxoLista;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/fluxodecaixa")
    @ResponseBody
    public ResponseEntity<FluxoDeCaixa> create(@RequestBody FluxoDeCaixa fluxoDeCaixa) {
        log.info("cadastrando categoria: {},", fluxoDeCaixa);
        fluxoLista.add(fluxoDeCaixa);
        return ResponseEntity.status(201).body(fluxoDeCaixa);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fluxodecaixa/{id}")
    @ResponseBody
    public ResponseEntity<FluxoDeCaixa> get(@PathVariable Long id) {
        log.info("buscando categoria com id {}", id);

        // stream
        var fluxodecaixa = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();

        log.info("categoria encontrada: {}", fluxodecaixa);

        if (fluxodecaixa == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(fluxodecaixa.get());
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/fluxodecaixa/{id}")
    @ResponseBody
    public ResponseEntity<FluxoDeCaixa> put(@PathVariable Long id, @RequestBody FluxoDeCaixa fluxoDeCaixa) {
        log.info("buscando categoria com id {}", id);

        // stream
        var fluxoencontrado = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();
        FluxoDeCaixa fluxoAtualizado = new FluxoDeCaixa(fluxoencontrado.get().id(), fluxoDeCaixa.tipo(),
                fluxoDeCaixa.valor(), fluxoDeCaixa.descricao(), fluxoDeCaixa.data());
        fluxoLista.remove(fluxoencontrado.get());
        fluxoLista.add(fluxoAtualizado);

        log.info("categoria encontrada e alterado: {}", fluxoAtualizado);

        if (fluxoencontrado == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(fluxoAtualizado);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/fluxodecaixa/{id}")
    @ResponseBody
    public ResponseEntity<FluxoDeCaixa> remove(@PathVariable Long id, @RequestBody FluxoDeCaixa fluxoDeCaixa) {
        log.info("buscando categoria com id {}", id);

        var fluxoEncontrado = fluxoLista.stream().filter(c -> c.id().equals(id)).findFirst();

        if (fluxoEncontrado.isEmpty()) {
            log.info("Fluxo de caixa com ID {} não encontrado", id);
            return ResponseEntity.status(404).build();
        }

        fluxoLista.remove(fluxoEncontrado.get());
        return ResponseEntity.status(204).body(fluxoEncontrado.get());

    }
}
