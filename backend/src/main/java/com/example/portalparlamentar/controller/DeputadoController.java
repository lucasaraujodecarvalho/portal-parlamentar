package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.services.DeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deputado")
public class DeputadoController {

    @Autowired
    private DeputadoService deputadoService;

    @GetMapping("/listar-deputados")
    public Deputado listarDeputados() {
        return deputadoService.getDeputados();
    }
}
