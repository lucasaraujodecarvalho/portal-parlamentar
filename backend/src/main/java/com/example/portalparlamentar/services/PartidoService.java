package com.example.portalparlamentar.services;

import com.example.portalparlamentar.models.Partido;
import com.example.portalparlamentar.models.ResultadoPartidosID;

import java.util.List;

public interface PartidoService {

    List<Partido> listarPartidos();

    ResultadoPartidosID detalharPartido(Integer idPartido);
}
