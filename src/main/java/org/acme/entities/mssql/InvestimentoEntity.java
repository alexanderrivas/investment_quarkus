package org.acme.entities.mssql;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "INVESTIMENTOS", schema = "dbo")
public class InvestimentoEntity {
    @Id
    private Long id;
    @Column(name = "cliente_id")
    private Long clienteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produto;

    private BigDecimal valor;
    private Double rentabilidade;
    private ZonedDateTime data;
}
