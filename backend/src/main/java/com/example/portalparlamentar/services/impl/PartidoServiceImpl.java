package com.example.portalparlamentar.services.impl;

import com.example.portalparlamentar.domain.Partido;
import com.example.portalparlamentar.domain.ResultadoPartidosID;
import com.example.portalparlamentar.repositories.PartidoRepository;
import com.example.portalparlamentar.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public List<Partido> listarPartidos() {
        return partidoRepository.listarPartidos();
    }

    @Override
    public ResultadoPartidosID detalharPartido(Integer idPartido) {
        return partidoRepository.detalharPartido(idPartido);
    }
}
