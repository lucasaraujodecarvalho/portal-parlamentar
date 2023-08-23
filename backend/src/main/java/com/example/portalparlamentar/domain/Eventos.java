package com.example.portalparlamentar.domain;

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
    private LocalCamara localCamara;
    private String localExterno;
    private List<Orgao> orgaos;
    private String situacao;
    private String uri;
    private String urlRegistro;
}
