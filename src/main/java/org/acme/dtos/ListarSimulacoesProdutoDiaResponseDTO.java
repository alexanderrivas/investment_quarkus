package org.acme.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarSimulacoesProdutoDiaResponseDTO {
    private String produto;
    private Date data;
    private Long quantidadeSimulacoes;
    private BigDecimal mediaValorFinal;
}
