package com.example.portalparlamentar.dto.deputados;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GabineteDTO {

    private String nome;
    private Integer predio;
    private Integer sala;
    private Integer andar;
    private String telefone;
    private String email;
}
