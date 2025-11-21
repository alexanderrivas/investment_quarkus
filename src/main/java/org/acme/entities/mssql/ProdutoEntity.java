package org.acme.entities.mssql;

import jakarta.persistence.*;
import lombok.*;
import org.acme.enums.TipoRisco;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRODUTO", schema = "dbo")
public class ProdutoEntity {

    @Id
    private Integer id;
    private String nome;
    private String tipo;
    private Double rentabilidade;
    @Enumerated(EnumType.STRING)
    private TipoRisco risco;
    @Column(name = "pontuacao_risco")
    private int pontuacaoRisco;
}
