package org.acme.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilRiscoResponseDTO {
    private Long clienteId;
    private String perfil;
    private Integer pontuacao;
    private String descricao;
}
