package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.models.DeputadoExpenses;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface DeputadoRepository {

    List<Deputado> listDeputados() throws JsonProcessingException;

    Deputado getDeputado(Integer idDeputado);

    List<DeputadoExpenses> getExpensesDeputados(Integer idDeputado) throws JsonProcessingException;
}
