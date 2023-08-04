package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.repositories.DeputadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class DeputadoRepositoryImpl implements DeputadoRepository {

    public Deputado getDeputado() {
        String api = "https://dadosabertos.camara.leg.br/api/v2/";
        String uri = api + "deputados";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(uri, Deputado.class);
        return dep.getBody();
    }
}
