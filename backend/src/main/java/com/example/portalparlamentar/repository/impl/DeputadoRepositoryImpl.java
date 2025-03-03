package com.example.portalparlamentar.repository.impl;

import com.example.portalparlamentar.config.ApiConfig;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.dto.deputados.DeputadoDTO;
import com.example.portalparlamentar.dto.deputados.InformacoesDeputadoDTO;
import com.example.portalparlamentar.exception.ResourceNotFoundException;
import com.example.portalparlamentar.repository.DeputadoRepository;
import com.example.portalparlamentar.utils.JsonParserUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeputadoRepositoryImpl implements DeputadoRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiConfig apiConfig;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String ENDPOINT_URL = "https://dadosabertos.camara.leg.br/api/v2/deputados";

    public List<DeputadoDTO> listarDeputados() {
        String endpointUrl = apiConfig.getCamaraBaseUrl() + "/deputados";
        ResponseEntity<String> respostaApi = restTemplate.exchange(
                endpointUrl,
                HttpMethod.GET,
                null,
                String.class
        );
        try {
            return JsonParserUtils.list(respostaApi.getBody(), DeputadoDTO.class);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Deputados não encontrados", e);
        }
    }

    public InformacoesDeputadoDTO obterDeputado(Integer idDeputado) {
        String endpointUrl = apiConfig.getCamaraBaseUrl() + "/deputados/{id}";
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("id", idDeputado);
        ResponseEntity<String> respostaApi = restTemplate.exchange(
                endpointUrl,
                HttpMethod.GET,
                null,
                String.class,
                uriParams
        );

        try {
            return JsonParserUtils.entity(respostaApi.getBody(), InformacoesDeputadoDTO.class);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Deputado não encontrado", e);
        }
    }

    @Override
    public List<DeputadoDespesas> listarDespesas(Integer idDeputado) throws JsonProcessingException {
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
    public List<Eventos> listarEventos(Integer idDeputado) throws JsonProcessingException {
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
