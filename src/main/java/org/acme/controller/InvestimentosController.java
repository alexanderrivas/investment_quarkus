package org.acme.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dtos.HistoricoInvestimentoDTO;
import org.acme.services.InvestimentoService;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("investimentos")
public class InvestimentosController {

    private final InvestimentoService investimentoService;

    public InvestimentosController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @GET
    @Path("{clienteId}")
    public List<HistoricoInvestimentoDTO> listarInvestimentosPorCliente(@PathParam("clienteId") Long clienteId) {
        return investimentoService.listarHistoricoInvestimentos(clienteId);
    }

}
