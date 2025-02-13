package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.dto.deputados.DeputadoDTO;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.dto.deputados.InformacoesDeputadoDTO;
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
@RequestMapping("/deputados")
public class DeputadoController {

    @Autowired
    private DeputadoService deputadoService;

    @GetMapping
    public ResponseEntity<List<DeputadoDTO>> listarDeputados() {
        return ResponseEntity.ok(deputadoService.listarDeputados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacoesDeputadoDTO> obterDeputado(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(deputadoService.obterDeputado(id));
    }

    @GetMapping("/{id}/despesas")
    public ResponseEntity<List<DeputadoDespesas>> listarDespesas(@PathVariable("id")Integer id) throws JsonProcessingException {
        return ResponseEntity.ok(deputadoService.listarDespesas(id));
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity<List<Eventos>> listarEventos(@PathVariable("id")Integer id) throws JsonProcessingException {
        return ResponseEntity.ok(deputadoService.listarEventos(id));
    }
}
