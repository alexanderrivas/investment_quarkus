package org.acme.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.ListarSimulacoesProdutoDiaDTO;
import org.acme.dtos.PerfilRiscoResponseDTO;
import org.acme.dtos.SimulacaoRequestDTO;
import org.acme.dtos.SimulacaoResponseDTO;
import org.acme.services.SimulacaoService;
import org.acme.services.TelemetriaService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class SimulacaoController {

    private final SimulacaoService simulacaoService;
    private final TelemetriaService telemetriaService;

    public SimulacaoController(SimulacaoService simulacaoService , TelemetriaService telemetriaService) {
        this.simulacaoService = simulacaoService;
        this.telemetriaService = telemetriaService;
    }

    @POST
    @Path("/simular-investimento")
    public Response simularInvestimento(SimulacaoRequestDTO requestDTO) {
        SimulacaoResponseDTO responseDTO =  simulacaoService.criarSimulacao(requestDTO);

        if (responseDTO == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao processar a simulação.")
                    .build();
        }

        return Response.ok(responseDTO).build();
    }

    @GET
    @Path("/simulacoes")
    public Response listarSimulacoes() {
        return Response.ok(simulacaoService.listarSimulacoes()).build();
    }

    @GET
    @Path("/simulacoes/por-produto-dia")
    public Response listarSimulacoesPorProdutoEDia() {

        return Response.ok(simulacaoService.listarSimulacoesProdutoDia()).build();
    }

    @GET
    @Path("/perfil-risco/{clienteId}")
    public Response obterPerfilRisco(@PathParam("clienteId") Long clienteId) {
        PerfilRiscoResponseDTO perfilRisco = simulacaoService.obterPerfilRisco(clienteId);
        if (perfilRisco == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Cliente não encontrado ou sem simulações e sem investimentos.")
                    .build();
        }
        return Response.ok(perfilRisco).build();
    }

    @GET
    @Path("/produtos-recomendados/{perfil}")
    public Response obterProdutosRecomendados(@PathParam("perfil") String perfil) {
        return Response.ok(simulacaoService.obterProdutosRecomendados(perfil)).build();
    }

    @GET
    @Path("/telemetria")
    public Response getTelemetria() {
        return Response.ok(telemetriaService.getTelemetria()).build();
    }


}
