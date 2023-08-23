package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.domain.Deputado;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface DeputadoRepository {

    List<Deputado> listDeputados() throws IOException;

    Deputado recuperarDeputado(Integer idDeputado);

    List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException;

    List<Eventos> listarEventosParticipacaoParlamentar(Integer idDeputado) throws JsonProcessingException;
}
