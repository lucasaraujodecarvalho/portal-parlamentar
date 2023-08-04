package com.example.portalparlamentar.services.impl;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.repositories.impl.DeputadoRepositoryImpl;
import com.example.portalparlamentar.services.DeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeputadoServiceImpl implements DeputadoService {

    @Autowired
    private DeputadoRepositoryImpl repository;

    @Override
    public Deputado getDeputados() {
        return repository.getDeputado();
    }
}
