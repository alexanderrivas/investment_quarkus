package org.acme.dtos;

import lombok.*;

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
    private String risco;
}
