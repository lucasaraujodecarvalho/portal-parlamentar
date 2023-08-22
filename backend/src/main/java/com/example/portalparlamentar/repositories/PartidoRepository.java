package com.example.portalparlamentar.repositories;

import com.example.portalparlamentar.models.Partido;
import com.example.portalparlamentar.models.ResultadoPartidosID;

import java.util.List;

public interface PartidoRepository {
    List<Partido> listarPartidos();

    ResultadoPartidosID detalharPartido(Integer idPartido);

}
