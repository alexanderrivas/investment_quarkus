package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.TelemetriaResponseDTO;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@ApplicationScoped
public class TelemetriaService {

    public static class EndpointMetric {
        public String nomeAPI;
        public AtomicInteger qtdRequisicoes = new AtomicInteger();
        public AtomicInteger qtdSucesso = new AtomicInteger();
        public AtomicLong tempoTotal = new AtomicLong();
        public Date dataPrimeiraChamada = new Date();

        public EndpointMetric(String nomeAPI) {
            this.nomeAPI = nomeAPI;
        }

        public synchronized void registrar(long tempo, boolean sucesso) {
            qtdRequisicoes.incrementAndGet();
            if (sucesso) qtdSucesso.incrementAndGet();
            tempoTotal.addAndGet(tempo);
            // Atualiza a data da primeira chamada se necessário
            if (qtdRequisicoes.get() == 1) {
                dataPrimeiraChamada = new Date();
            }
        }

        public long getTempoMedio() {
            return qtdRequisicoes.get() == 0 ? 0 : tempoTotal.get() / qtdRequisicoes.get();
        }

        public Date getDataPrimeiraChamada() {
            return dataPrimeiraChamada;
        }

    }

    private final Map<String, EndpointMetric> metricas = new ConcurrentHashMap<>();

    public void registrar(String nomeAPI, long tempo, boolean sucesso) {
        metricas.computeIfAbsent(nomeAPI, k -> new EndpointMetric(nomeAPI)).registrar(tempo, sucesso);
    }

    public List<EndpointMetric> listarMetricas() {
        return new ArrayList<>(metricas.values());
    }

    public TelemetriaResponseDTO getTelemetria() {
        TelemetriaResponseDTO resp = new TelemetriaResponseDTO();
        resp.servicos = listarMetricas().stream().map(m -> {
            TelemetriaResponseDTO.EndpointDTO dto = new TelemetriaResponseDTO.EndpointDTO();
            dto.nome = m.nomeAPI;
            dto.quantidadeChamadas = m.qtdRequisicoes.get();
            dto.mediaTempoRespostaMs = m.getTempoMedio();
            return dto;
        }).collect(Collectors.toList());
        resp.periodo = new TelemetriaResponseDTO.PeriodoDTO();
        Date inicioDate = listarMetricas().stream()
                .map(EndpointMetric::getDataPrimeiraChamada)
                .min(Date::compareTo)
                .orElse(new Date());
        resp.periodo.inicio = inicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        resp.periodo.fim = new Date().toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_LOCAL_DATE);

        return resp;
    }
}