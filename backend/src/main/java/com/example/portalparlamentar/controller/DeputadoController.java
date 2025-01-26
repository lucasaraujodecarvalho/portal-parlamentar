package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.dto.DeputadoDTO;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.service.DeputadoService;
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

    @GetMapping
    public ResponseEntity<List<DeputadoDTO>> listarDeputados() {
        return ResponseEntity.ok().body(deputadoService.listarDeputados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeputadoDTO> obterDeputado(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(deputadoService.obterDeputado(id));
    }

    @GetMapping("/{idDeputado}/despesas")
    public ResponseEntity<List<DeputadoDespesas>> listarDespesas(@PathVariable("idDeputado")Integer idDeputado) throws JsonProcessingException {
        return ResponseEntity.ok().body(deputadoService.listarDespesas(idDeputado));
    }

    @GetMapping("/{idDeputado}/eventos")
    public ResponseEntity<List<Eventos>> listarEventos(@PathVariable("idDeputado")Integer idDeputado) throws JsonProcessingException {
        return ResponseEntity.ok().body(deputadoService.listarEventos(idDeputado));
    }
}
