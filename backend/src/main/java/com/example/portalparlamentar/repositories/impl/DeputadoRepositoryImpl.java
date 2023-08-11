package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.models.DeputadoDespesas;
import com.example.portalparlamentar.repositories.DeputadoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeputadoRepositoryImpl implements DeputadoRepository {

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    public List<Deputado> listDeputados() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        //        ResponseEntity<Deputado> dep = restTemplate.getForEntity(ENDPOINT_URL + "deputados", Deputado.class);
        ResponseEntity<String> respostaApi = restTemplate.getForEntity(ENDPOINT_URL + "deputados", String.class);
        JsonNode jsonNode = objectMapper.readTree(respostaApi.getBody());
        String json = String.valueOf(jsonNode.get("dados"));

        return objectMapper.readValue(json, new TypeReference<>() {});

//        return List.of(objectMapper.readValue(json, Deputado[].class));
    }

    public Deputado recuperarDeputado(Integer idDeputado) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "deputados" + "/{id}";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        //TODO ajustar o mapeamento da entidade
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(url, Deputado.class, uriParams);
        return dep.getBody();
    }

    @Override
    public List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "deputados/{id}/despesas";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        ResponseEntity<String> respostaApi = restTemplate.getForEntity(url, String.class, uriParams);
        JsonNode jsonNode = objectMapper.readTree(respostaApi.getBody());
        String json = String.valueOf(jsonNode.get("dados"));
        return objectMapper.readValue(json, new TypeReference<>() {});
    }
}
