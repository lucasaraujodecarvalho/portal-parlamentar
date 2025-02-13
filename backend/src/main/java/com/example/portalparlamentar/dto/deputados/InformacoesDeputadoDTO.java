package com.example.portalparlamentar.dto.deputados;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private List<String> redesSociais;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private String ufNascimento;
    private String municipioNascimento;
    private String escolaridade;
}
