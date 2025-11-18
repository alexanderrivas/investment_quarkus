package org.acme.entities;

import jakarta.persistence.*;
import lombok.*;
import org.acme.enums.TipoRisco;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PRODUTO")
public class ProdutoEntity {

    @Id
    private Integer id;
    private String nome;
    private String tipo;
    private Double rentabilidade;
    @Enumerated(EnumType.STRING)
    private TipoRisco risco;

}
