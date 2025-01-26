package com.example.portalparlamentar.repository;

import com.example.portalparlamentar.dto.DeputadoDTO;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface DeputadoRepository {

    List<DeputadoDTO> listarDeputados() throws IOException;

    DeputadoDTO obterDeputado(Integer id);

    List<DeputadoDespesas> listarDespesas(Integer idDeputado) throws JsonProcessingException;

    List<Eventos> listarEventos(Integer idDeputado) throws JsonProcessingException;
}
