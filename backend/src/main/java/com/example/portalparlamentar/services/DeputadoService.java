package com.example.portalparlamentar.services;

import com.example.portalparlamentar.domain.Deputado;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DeputadoService {

    List<Deputado> listDeputados();

    Deputado recuperarDeputado(Integer idDeputado);

    List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException;

    List<Eventos> listarEventosParticipacaoParlamentar(Integer idDeputado) throws JsonProcessingException;
}
