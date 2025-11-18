package org.acme.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "INVESTIMENTOS")
public class HistoricoInvestimentoEntity {
    @Id
    private Long id;
    @Column(name = "cliente_id")
    private Long clienteId;
    private String tipo;
    private Double valor;
    private Double rentabilidade;
    private String data;

}
