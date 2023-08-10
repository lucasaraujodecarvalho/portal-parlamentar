package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.models.DeputadoExpenses;
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

    @GetMapping("/list-deputados")
    public ResponseEntity<List<Deputado>> listDeputados() throws JsonProcessingException {
        List<Deputado> deputado = deputadoService.listDeputados();
        return ResponseEntity.ok().body(deputado);
    }

    @GetMapping("/get-deputado/{id}")
    public ResponseEntity<Deputado> getDeputado(@PathVariable("id") Integer idDeputado) {
        return ResponseEntity.ok().body(deputadoService.getDeputado(idDeputado));
    }

    @GetMapping("/get-deputado-expenses/{id}")
    public ResponseEntity<List<DeputadoExpenses>> getExpensesDeputados(@PathVariable("id")Integer idDeputado) throws JsonProcessingException {
        List<DeputadoExpenses> deputadoDespesas = deputadoService.getExpensesDeputados(idDeputado);
        return ResponseEntity.ok().body(deputadoDespesas);
    }

}
