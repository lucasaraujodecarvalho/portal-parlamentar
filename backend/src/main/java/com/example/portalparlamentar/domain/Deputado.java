package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Deputado {

    private String email;
    private Integer id;
    private Integer idLegislatura;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private String uri;
    private String uriPartido;
    private String urlFoto;
}
