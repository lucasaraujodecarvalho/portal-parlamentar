package com.example.portalparlamentar.repositories.impl;

import com.example.portalparlamentar.domain.Deputado;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.repositories.DeputadoRepository;
import com.example.portalparlamentar.utils.JsonParserUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
public class DeputadoRepositoryImpl implements DeputadoRepository {

    @Autowired
    private ObjectMapper objectMapper;

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/deputados";

    public List<Deputado> listDeputados() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> respostaApi = restTemplate.getForEntity(ENDPOINT_URL, String.class);
            JsonNode jsonNode = JsonParserUtils.readTree(respostaApi.getBody());
            String json = String.valueOf(jsonNode.get("dados"));
            return JsonParserUtils.arrayList(json, Deputado.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Deputado recuperarDeputado(Integer idDeputado) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "/{id}";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        //TODO ajustar o mapeamento da entidade
        ResponseEntity<Deputado> dep = restTemplate.getForEntity(url, Deputado.class, uriParams);
        return dep.getBody();
    }

    @Override
    public List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "/{id}/despesas";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        ResponseEntity<String> respostaApi = restTemplate.getForEntity(url, String.class, uriParams);
        JsonNode jsonNode = objectMapper.readTree(respostaApi.getBody());
        String json = String.valueOf(jsonNode.get("dados"));
        return objectMapper.readValue(json, new TypeReference<>() {});
    }

    @Override
    public List<Eventos> listarEventosParticipacaoParlamentar(Integer idDeputado) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENDPOINT_URL + "/{id}/eventos";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        ResponseEntity<String> respostaApi = restTemplate.getForEntity(url, String.class, uriParams);
        JsonNode jsonNode = objectMapper.readTree(respostaApi.getBody());
        String json = String.valueOf(jsonNode.get("dados"));
        return objectMapper.readValue(json, new TypeReference<>() {});
    }
}
