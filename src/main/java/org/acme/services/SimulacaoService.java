package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.ProdutoValidadoDTO;
import org.acme.dtos.ResultadoSimulacaoDTO;
import org.acme.dtos.SimulacaoRequestDTO;
import org.acme.dtos.SimulacaoResponseDTO;
import org.acme.entities.ProdutoEntity;
import org.acme.repository.ProdutoRepository;

import java.util.List;

@ApplicationScoped
public class SimulacaoService {

    private final ProdutoRepository produtoRepository;

    public SimulacaoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public SimulacaoResponseDTO criarSimulacao(SimulacaoRequestDTO request) {

        // Lógica para criar a simulação com base no request e nos produtos
        List<ProdutoEntity> produto = produtoRepository.findByTipoProduto(request.getTipoProduto());

        if (produto.isEmpty()) {
            return null;
        }

        ProdutoValidadoDTO produtoValidadoDTO = new ProdutoValidadoDTO();
        produtoValidadoDTO.setId(produto.getFirst().getId());
        ResultadoSimulacaoDTO resultadoSimulacaoDTO = new ResultadoSimulacaoDTO();

        // Preencher o response com os dados da simulação
        SimulacaoResponseDTO response = new SimulacaoResponseDTO();
        response.setResultadoSimulacao(resultadoSimulacaoDTO);
        response.setProdutoValidado(produtoValidadoDTO);

        return response;
    }

}
