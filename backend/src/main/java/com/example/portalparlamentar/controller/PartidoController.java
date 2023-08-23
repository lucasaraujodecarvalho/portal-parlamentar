package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.domain.Partido;
import com.example.portalparlamentar.domain.ResultadoPartidosID;
import com.example.portalparlamentar.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping("/lista-partidos")
    public ResponseEntity<List<Partido>> listaPartidos() {
        List<Partido> partidos = partidoService.listarPartidos();
        return ResponseEntity.ok().body(partidos);
    }

    @GetMapping("/detalhar-partido/{id}")
    public ResponseEntity<ResultadoPartidosID> detalharPartido(@PathVariable Integer id) {
        ResultadoPartidosID partido = partidoService.detalharPartido(id);
        return ResponseEntity.ok().body(partido);
    }
}
