package org.acme.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ListarSimulacoesProdutoDiaDTO {
    private Integer produtoId;
    private Date data;
    private Long quantidadeSimulacoes;
    private BigDecimal mediaValorFinal;

    // construtor usado pelo JPQL: (String, LocalDate, Long, Double/BigDecimal)
    public ListarSimulacoesProdutoDiaDTO(Integer produtoId,
                                         Date data,
                                         Long quantidadeSimulacoes,
                                         BigDecimal mediaValorFinal) {
        this.produtoId = produtoId;
        this.data = data;
        this.quantidadeSimulacoes = quantidadeSimulacoes;
        this.mediaValorFinal = mediaValorFinal;
    }
}
