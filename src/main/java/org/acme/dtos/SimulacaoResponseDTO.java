package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SimulacaoResponseDTO {

    private ProdutoValidadoDTO produtoValidado;
    private ResultadoSimulacaoDTO resultadoSimulacao;
    private String dataSimulacao; // ex: "2025-10-31T14:00:00Z"

    public SimulacaoResponseDTO() {
        dataSimulacao = ZonedDateTime.now().toString();
    }

}
