package com.example.portalparlamentar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartidoIdStatus {

    private String data;
    private String idLegislatura;
    private PartidoLider lider;

}
