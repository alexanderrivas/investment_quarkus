package org.acme.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultadoSimulacaoDTO {
    private BigDecimal valorFinal;
    private Double rentabilidadeEfetiva;
    private Integer prazoMeses;
}
