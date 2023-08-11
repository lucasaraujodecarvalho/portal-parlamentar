package com.example.portalparlamentar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Eventos {

    private String dataHoraFim;
    private String dataHoraInicio;
    private String descricao;
    private String descricaoTipo;
    private Integer id;
    private List<LocalCamara> localCamaras;
    private String localExterno;
    private List<Orgao> orgaos;
    private String situacao;
    private String uri;
    private String urlRegistro;
}
