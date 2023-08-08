package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.repositories.DeputadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeputadoRepositoryImpl implements DeputadoRepository {

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    public Deputado listDeputados() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(ENDPOINT_URL + "deputados", Deputado.class);
//        ResponseEntity<String> respostaApi = restTemplate.getForEntity(ENDPOINT_URL + "deputados", String.class);
        return dep.getBody();
    }

    public Deputado getDeputado(Integer idDeputado) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "deputados" + "/{id}";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        //TODO ajustar o mapeamento da entidade
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(url, Deputado.class, uriParams);
        return dep.getBody();
    }
}
