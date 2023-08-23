package com.example.portalparlamentar.services;

import com.example.portalparlamentar.domain.Partido;
import com.example.portalparlamentar.domain.ResultadoPartidosID;

import java.util.List;

public interface PartidoService {

    List<Partido> listarPartidos();

    ResultadoPartidosID detalharPartido(Integer idPartido);
}
