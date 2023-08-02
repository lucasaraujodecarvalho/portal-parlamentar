package com.example.portalparlamentar.controller;

import com.example.portalparlamentar.models.Deputado;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/deputado")
public class DeputadoController {

    @RequestMapping("/listar-deputados")
    public Deputado listarDeputados() {
        String api = "https://dadosabertos.camara.leg.br/api/v2/";
        String uri = api + "deputados";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(uri);
        return restTemplate.getForObject(uri, Deputado.class);
    }
}
