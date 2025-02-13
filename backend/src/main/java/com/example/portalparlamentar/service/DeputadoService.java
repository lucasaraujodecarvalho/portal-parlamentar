package com.example.portalparlamentar.service;

import com.example.portalparlamentar.dto.deputados.DeputadoDTO;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.dto.deputados.InformacoesDeputadoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DeputadoService {

    List<DeputadoDTO> listarDeputados();

    InformacoesDeputadoDTO obterDeputado(Integer idDeputado);

    List<DeputadoDespesas> listarDespesas(Integer idDeputado) throws JsonProcessingException;

    List<Eventos> listarEventos(Integer idDeputado) throws JsonProcessingException;
}
