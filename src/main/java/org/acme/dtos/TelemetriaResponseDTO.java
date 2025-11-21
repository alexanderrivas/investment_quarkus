package org.acme.dtos;

import java.util.List;

public class TelemetriaResponseDTO {
    public List<EndpointDTO> servicos;
    public PeriodoDTO periodo;

    public static class EndpointDTO {
        public String nome;
        public int quantidadeChamadas;
        public long mediaTempoRespostaMs;
    }

    public static class PeriodoDTO {
        public String inicio;
        public String fim;
    }
}