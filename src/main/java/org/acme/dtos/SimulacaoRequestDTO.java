package org.acme.dtos;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimulacaoRequestDTO {

    @NotNull
    private Long clienteId;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Min(1)
    private Integer prazoMeses;

    @NotNull
    private String tipoProduto;
}
