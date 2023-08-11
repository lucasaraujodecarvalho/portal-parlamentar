package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.models.DeputadoDespesas;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DeputadoRepository {

    List<Deputado> listDeputados() throws JsonProcessingException;

    Deputado recuperarDeputado(Integer idDeputado);

    List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException;
}
