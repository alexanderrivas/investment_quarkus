package org.acme.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListarSimulacoesDTO {
    private Long id;
    private Long clienteId;
    private String produto;
    private Double valorInvestido;
    private Double valorFinal;
    private Integer prazoMeses;
    private ZonedDateTime dataSimulacao;
}
