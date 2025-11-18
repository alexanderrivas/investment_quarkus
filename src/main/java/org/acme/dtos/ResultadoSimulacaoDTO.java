package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoSimulacaoDTO {
    private Double valorFinal;
    private Double rentabilidadeEfetiva;
    private Integer prazoMeses;
}
