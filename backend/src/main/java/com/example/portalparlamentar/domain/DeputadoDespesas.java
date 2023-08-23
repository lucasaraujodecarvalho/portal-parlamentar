package com.example.portalparlamentar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DeputadoDespesas {

    private Integer ano;
    private String cnpjCpfFornecedor;
    private Integer codDocumento;
    private Integer codLote;
    private Integer codTipoDocumento;
    private String dataDocumento;
    private Integer mes;
    private String nomeFornecedor;
    private String numDocumento;
    private String numRessarcimento;
    private Integer parcela;
    private String tipoDespesa;
    private String tipoDocumento;
    private String urlDocumento;
    private BigDecimal valorDocumento;
    private BigDecimal valorGlosa;
    private BigDecimal valorLiquido;
}
