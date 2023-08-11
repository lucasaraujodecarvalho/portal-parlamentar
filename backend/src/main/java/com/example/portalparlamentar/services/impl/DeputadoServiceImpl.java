package com.example.portalparlamentar.services.impl;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.models.DeputadoDespesas;
import com.example.portalparlamentar.repositories.impl.DeputadoRepositoryImpl;
import com.example.portalparlamentar.services.DeputadoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeputadoServiceImpl implements DeputadoService {

    @Autowired
    private DeputadoRepositoryImpl repository;

    @Override
    public List<Deputado> listDeputados() throws JsonProcessingException {
        return repository.listDeputados();
    }

    @Override
    public Deputado recuperarDeputado(Integer idDeputado) {
        return repository.recuperarDeputado(idDeputado);
    }

    @Override
    public List<DeputadoDespesas> recuperarDespesasDoDeputado(Integer idDeputado) throws JsonProcessingException {
        return repository.recuperarDespesasDoDeputado(idDeputado);
    }
}
