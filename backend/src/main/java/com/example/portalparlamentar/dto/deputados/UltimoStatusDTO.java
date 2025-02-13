package com.example.portalparlamentar.dto.deputados;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UltimoStatusDTO {

    private Integer id;
    private String uri;
    private String nome;
    private String siglaPartido;
    private String uriPartido;
    private String siglaUf;
    private Integer idLegislatura;
    private String urlFoto;
    private String email;
    private LocalDate data;
    private String nomeEleitoral;
    private GabineteDTO gabinete;
    private String situacao;
    private String condicaoEleitoral;
    private String descricaoStatus;

}
