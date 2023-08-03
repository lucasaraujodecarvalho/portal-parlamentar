package com.example.portalparlamentar.services;

import com.example.portalparlamentar.models.Deputado;
import com.example.portalparlamentar.repositories.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    public Deputado getDeputados() {
     return deputadoRepository.getDeputado();
    }
}
