package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.models.Deputado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class DeputadoRepository {

    public Deputado getDeputado() {
        String api = "https://dadosabertos.camara.leg.br/api/v2/";
        String uri = api + "deputados";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(uri, Deputado.class);
        return dep.getBody();
    }
}
