package org.acme.dtos;

import lombok.*;
import org.acme.enums.TipoRisco;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoValidadoDTO {
    private Integer id;
    private String nome;
    private String tipo;
    private Double rentabilidade;
    private TipoRisco risco;
}
