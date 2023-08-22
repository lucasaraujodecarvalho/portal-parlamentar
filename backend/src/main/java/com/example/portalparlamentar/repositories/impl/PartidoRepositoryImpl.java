package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.models.Partido;
import com.example.portalparlamentar.models.ResultadoPartidosID;
import com.example.portalparlamentar.repositories.PartidoRepository;
import com.example.portalparlamentar.utils.JsonParserUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PartidoRepositoryImpl implements PartidoRepository {

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/partidos";

    @Autowired
    private ObjectMapper objectMapper;

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

    @Override
    public ResultadoPartidosID detalharPartido(Integer idPartido) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String api = ENDPOINT_URL + "/{id}";
            Map<String, Integer> uriParams = new HashMap<>();
            uriParams.put("id", idPartido);
            ResponseEntity<String> respostaApi = restTemplate.getForEntity(api, String.class, uriParams);
            JsonNode jsonNode = objectMapper.readTree(respostaApi.getBody());
            String json = String.valueOf(jsonNode.get("dados"));
            return objectMapper.readValue(json, ResultadoPartidosID.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
