package org.acme.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.SimulacaoRequestDTO;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("simular-investimento")
public class SimulacaoController {

    @POST
    public Response simularInvestimento(SimulacaoRequestDTO requestDTO) {
        return Response.ok(requestDTO).build();
    }
}
