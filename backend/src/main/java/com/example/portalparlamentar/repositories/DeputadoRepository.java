package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.models.Deputado;

public interface DeputadoRepository {

    Deputado listDeputados();

    Deputado getDeputado(Integer idDeputado);
}
