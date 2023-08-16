package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.models.Partido;
import com.example.portalparlamentar.repositories.PartidoRepository;
import com.example.portalparlamentar.utils.JsonParserUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Repository
public class PartidoRepositoryImpl implements PartidoRepository {

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/partidos";

    @Override
    public List<Partido> listarPartidos() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> respostaApi = restTemplate.getForEntity(ENDPOINT_URL, String.class);
            JsonNode jsonNode = JsonParserUtils.readTree(respostaApi.getBody());
            String json = String.valueOf(jsonNode.get("dados"));
            return JsonParserUtils.arrayList(json, Partido.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
