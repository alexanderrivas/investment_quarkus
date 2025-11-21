package org.acme.dtos;

import lombok.*;
import org.acme.entities.mssql.InvestimentoEntity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoInvestimentoDTO {
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private Double rentabilidade;
    private String data;

    public static HistoricoInvestimentoDTO fromEntity(InvestimentoEntity investimentoEntity) {
        return new HistoricoInvestimentoDTO(
                investimentoEntity.getId(),
                investimentoEntity.getProduto().getTipo(),
                investimentoEntity.getValor(),
                investimentoEntity.getRentabilidade(),
                investimentoEntity.getData().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
        );

    }
}
