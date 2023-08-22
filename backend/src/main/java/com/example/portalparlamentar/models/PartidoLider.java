package com.example.portalparlamentar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartidoLider {

    private Integer idLegislatura;
    private String nome;
    private String siglaPartido;
    private String uf;
    private String uri;
    private String uriPartido;
    private String urlFoto;
}
