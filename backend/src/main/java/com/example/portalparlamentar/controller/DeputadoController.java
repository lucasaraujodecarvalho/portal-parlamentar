package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.services.DeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deputado")
public class DeputadoController {

    @Autowired
    private DeputadoService deputadoService;

    @GetMapping("/list-deputados")
    public ResponseEntity<Deputado> listDeputados() {
        Deputado deputado = deputadoService.listDeputados();
        return ResponseEntity.ok().body(deputado);
    }

    @GetMapping("/get-deputado/{id}")
    public ResponseEntity<Deputado> getDeputado(@PathVariable("id") Integer idDeputado) {
        return ResponseEntity.ok().body(deputadoService.getDeputado(idDeputado));
    }

}
