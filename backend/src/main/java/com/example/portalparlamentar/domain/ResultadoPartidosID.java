package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultadoPartidosID {

    private Integer id;
    private String nome;
    private Integer numeroEleitoral;
    private String sigla;
    private PartidoIdStatus status;
    private String uri;
    private String urlFacebook;
    private String urlLogo;
    private String urlWebsite;

}
