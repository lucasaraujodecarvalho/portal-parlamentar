package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.domain.Partido;
import com.example.portalparlamentar.domain.ResultadoPartidosID;

import java.util.List;

public interface PartidoRepository {
    List<Partido> listarPartidos();

    ResultadoPartidosID detalharPartido(Integer idPartido);

}
