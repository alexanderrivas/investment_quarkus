package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.HistoricoInvestimentoDTO;
import org.acme.entities.mssql.InvestimentoEntity;
import org.acme.repository.InvestimentoRepository;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class InvestimentoService {

    private final InvestimentoRepository repository;

    public InvestimentoService(InvestimentoRepository repository) {
        this.repository = repository;
    }

    public List<HistoricoInvestimentoDTO> listarHistoricoInvestimentos(Long clientId){

        List<InvestimentoEntity> entidades = repository.findByClienteId(clientId);

        return entidades.stream()
                .map(HistoricoInvestimentoDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
