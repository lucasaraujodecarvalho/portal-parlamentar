package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Partido {

    private String id;
    private String nome;
    private String sigla;
    private String uri;
}
