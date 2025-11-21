package org.acme.entities.local;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.entities.mssql.ProdutoEntity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SIMULACAO")
public class SimulacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long clienteId;
    private Integer produtoId;
    private BigDecimal valor;
    private BigDecimal valorFinal;
    private Integer prazoMeses;
    private ZonedDateTime dataSimulacao;

}
