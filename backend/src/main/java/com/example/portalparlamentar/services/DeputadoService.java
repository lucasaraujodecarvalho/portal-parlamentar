package com.example.portalparlamentar.services;

import com.example.portalparlamentar.models.Deputado;

public interface DeputadoService {

    Deputado listDeputados();

    Deputado getDeputado(Integer idDeputado);
}
