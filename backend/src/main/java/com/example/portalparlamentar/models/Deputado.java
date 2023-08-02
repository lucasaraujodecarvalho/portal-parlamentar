package com.example.portalparlamentar.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Deputado {

    private ArrayList<Deputado> dados = new ArrayList<>();
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
