package org.acme.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.SimulacaoRequestDTO;
import org.acme.dtos.SimulacaoResponseDTO;
import org.acme.services.SimulacaoService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("simular-investimento")
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    public SimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @POST
    public Response simularInvestimento(SimulacaoRequestDTO requestDTO) {
        SimulacaoResponseDTO responseDTO =  simulacaoService.criarSimulacao(requestDTO);

        if (responseDTO == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao processar a simulação.")
                    .build();
        }

        return Response.ok(responseDTO).build();
    }
}
