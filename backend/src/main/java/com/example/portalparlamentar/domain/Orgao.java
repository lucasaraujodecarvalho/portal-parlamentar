package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Orgao {

    private String apelido;
    private Integer codTipoOrgao;
    private Integer id;
    private String nome;
    private String nomePublicacao;
    private String nomeResumido;
    private String sigla;
    private String tipoOrgao;
    private String uri;
}
