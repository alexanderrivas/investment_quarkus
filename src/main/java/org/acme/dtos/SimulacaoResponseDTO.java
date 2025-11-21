package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SimulacaoResponseDTO {

    private ProdutoValidadoDTO produtoValidado;
    private ResultadoSimulacaoDTO resultadoSimulacao;
    private ZonedDateTime dataSimulacao; // ex: "2025-10-31T14:00:00Z"

    public SimulacaoResponseDTO() {
        dataSimulacao = ZonedDateTime.now();
    }

}
