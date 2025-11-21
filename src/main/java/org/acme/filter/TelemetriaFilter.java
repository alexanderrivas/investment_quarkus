// TelemetriaFilter.java
package org.acme.filter;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.acme.services.TelemetriaService;

import java.io.IOException;

@Provider
public class TelemetriaFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Inject
    TelemetriaService telemetriaService;

    private static final String START_TIME = "start-time";
    private static final String NOME_API = "nome-api";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.setProperty(START_TIME, System.currentTimeMillis());
        String path = requestContext.getUriInfo().getPath();
        String nomeAPI = path.contains("simulador") ? "Simulacao" : path;
        requestContext.setProperty(NOME_API, nomeAPI);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Long start = (Long) requestContext.getProperty(START_TIME);
        String nomeAPI = (String) requestContext.getProperty(NOME_API);
        if (start != null && nomeAPI != null) {
            long tempo = System.currentTimeMillis() - start;
            boolean sucesso = responseContext.getStatus() < 400;
            telemetriaService.registrar(nomeAPI, tempo, sucesso);
        }
    }
}