package com.example.portalparlamentar.service.impl;

import com.example.portalparlamentar.dto.DeputadoDTO;
import com.example.portalparlamentar.domain.DeputadoDespesas;
import com.example.portalparlamentar.domain.Eventos;
import com.example.portalparlamentar.repository.impl.DeputadoRepositoryImpl;
import com.example.portalparlamentar.service.DeputadoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeputadoServiceImpl implements DeputadoService {

    @Autowired
    private DeputadoRepositoryImpl repository;

    @Override
    public List<DeputadoDTO> listarDeputados() {
        return repository.listarDeputados();
    }

    @Override
    public DeputadoDTO obterDeputado(Integer idDeputado) {
        return repository.obterDeputado(idDeputado);
    }

    @Override
    public List<DeputadoDespesas> listarDespesas(Integer idDeputado) throws JsonProcessingException {
        return repository.listarDespesas(idDeputado);
    }

    @Override
    public List<Eventos> listarEventos(Integer idDeputado) throws JsonProcessingException {
        return repository.listarEventos(idDeputado);
    }
}
