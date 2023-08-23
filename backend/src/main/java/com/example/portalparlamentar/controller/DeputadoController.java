package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.domain.Deputado;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.services.DeputadoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/deputado")
public class DeputadoController {

    @Autowired
    private DeputadoService deputadoService;

    @GetMapping("/lista-deputados")
    public ResponseEntity<List<Deputado>> listaDeputados() {
        List<Deputado> deputado = deputadoService.listDeputados();
        return ResponseEntity.ok().body(deputado);
    }

    @GetMapping("/recuperar-deputado/{id}")
    public ResponseEntity<Deputado> recuperarDeputado(@PathVariable("id") Integer idDeputado) {
        return ResponseEntity.ok().body(deputadoService.recuperarDeputado(idDeputado));
    }

    @GetMapping("/deputado-despesas/{id}")
    public ResponseEntity<List<DeputadoDespesas>> recuperarDespesasDoDeputado(@PathVariable("id")Integer idDeputado) throws JsonProcessingException {
        List<DeputadoDespesas> deputadoDespesas = deputadoService.recuperarDespesasDoDeputado(idDeputado);
        return ResponseEntity.ok().body(deputadoDespesas);
    }

    @GetMapping("/eventos-deputado/{id}")
    public ResponseEntity<List<Eventos>> listarEventosParticipacaoParlamentar(@PathVariable("id")Integer idDeputado) throws JsonProcessingException {
        List<Eventos> eventos = deputadoService.listarEventosParticipacaoParlamentar(idDeputado);
        return ResponseEntity.ok().body(eventos);
    }
}
