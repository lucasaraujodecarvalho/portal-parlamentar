package com.example.portalparlamentar.dto.deputados;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InformacoesDeputadoDTO {

    private Integer id;
    private String uri;
    private String nomeCivil;
    private UltimoStatusDTO ultimoStatus;
    private String cpf;
    private String sexo;
    private String urlWebsite;
    @JsonProperty("redeSocial")
    private List<String> redesSociais;
    private String dataNascimento;
    private String dataFalecimento;
    private String ufNascimento;
    private String municipioNascimento;
    private String escolaridade;
}
