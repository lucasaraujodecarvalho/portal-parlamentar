package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocalCamara {

    private String andar;
    private String nome;
    private String predio;
    private String sala;
}
