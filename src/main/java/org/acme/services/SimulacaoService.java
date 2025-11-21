package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.acme.dtos.*;
import org.acme.entities.mssql.InvestimentoEntity;
import org.acme.entities.mssql.ProdutoEntity;
import org.acme.entities.local.SimulacaoEntity;
import org.acme.repository.InvestimentoRepository;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.SimulacaoRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class SimulacaoService {

    private final ProdutoRepository produtoRepository;
    private final SimulacaoRepository simulacaoRepository;
    private final RecomendacaoService recomendacaoService;
    private final InvestimentoRepository investimentoRepository;

    public SimulacaoService(ProdutoRepository produtoRepository, SimulacaoRepository simulacaoRepository, RecomendacaoService recomendacaoService, InvestimentoRepository investimentoRepository) {
        this.produtoRepository = produtoRepository;
        this.simulacaoRepository = simulacaoRepository;
        this.recomendacaoService = recomendacaoService;
        this.investimentoRepository = investimentoRepository;
    }

    public SimulacaoResponseDTO criarSimulacao(@Valid SimulacaoRequestDTO request) {

        // Lógica para criar a simulação com base no request e nos produtos
        Optional<ProdutoEntity> produto = produtoRepository.findByTipoProduto(request.getTipoProduto());

        // Verificar se o produto foi encontrado
        if (produto.isEmpty()) {
            return null;
        }

        // calcular resultado da simulação (lógica fictícia)
        BigDecimal valorFinal = calcularValorFinal(request.getValor(), request.getPrazoMeses(), produto.get().getRentabilidade());

        // Salvar a simulação no banco de dados
        try {
            salvarSimulacao(request, produto.get(), valorFinal);
        } catch (Exception e) {
            return null;
        }

        // Preencher os DTOs de resposta
        ProdutoValidadoDTO produtoValidadoDTO = new ProdutoValidadoDTO();
        produtoValidadoDTO.setId(produto.get().getId());
        produtoValidadoDTO.setNome(produto.get().getNome());
        produtoValidadoDTO.setTipo(produto.get().getTipo());
        produtoValidadoDTO.setRentabilidade(produto.get().getRentabilidade());
        produtoValidadoDTO.setRisco(produto.get().getRisco());

        ResultadoSimulacaoDTO resultadoSimulacaoDTO = new ResultadoSimulacaoDTO();
        resultadoSimulacaoDTO.setPrazoMeses(request.getPrazoMeses());
        resultadoSimulacaoDTO.setValorFinal(valorFinal);
        resultadoSimulacaoDTO.setRentabilidadeEfetiva(produto.get().getRentabilidade());

        // Preencher o response com os dados da simulação
        SimulacaoResponseDTO response = new SimulacaoResponseDTO();
        response.setResultadoSimulacao(resultadoSimulacaoDTO);
        response.setProdutoValidado(produtoValidadoDTO);

        return response;
    }

    @Transactional
    public void salvarSimulacao(SimulacaoRequestDTO request, ProdutoEntity produtoEntity, BigDecimal valorFinal) {
        SimulacaoEntity simulacao = new SimulacaoEntity();
        simulacao.setClienteId(request.getClienteId());
        simulacao.setProdutoId(produtoEntity.getId());
        simulacao.setValor(request.getValor());
        simulacao.setValorFinal(valorFinal);
        simulacao.setPrazoMeses(request.getPrazoMeses());
        simulacao.setDataSimulacao(ZonedDateTime.now());

        simulacaoRepository.persist(simulacao);
    }

    private BigDecimal calcularValorFinal(BigDecimal valorInicial, Integer prazoMeses, Double rentabilidade) {
        // Lógica fictícia para calcular o valor final considerando rentabilidade anual simples
        return valorInicial.add(valorInicial.multiply(BigDecimal.valueOf(rentabilidade)).multiply(BigDecimal.valueOf(prazoMeses)).divide(BigDecimal.valueOf(12), RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
    }

    public List<ListarSimulacoesDTO> listarSimulacoes() {

        List<SimulacaoEntity> simulacaoEntities = simulacaoRepository.listAll();


        List<ListarSimulacoesDTO> simulacoesDTOList = simulacaoEntities.stream().map(simulacao -> {
            ProdutoEntity produto = produtoRepository.findById(simulacao.getProdutoId());

            ListarSimulacoesDTO dto = new ListarSimulacoesDTO();
            dto.setId(simulacao.getId());
            dto.setClienteId(simulacao.getClienteId());
            dto.setProduto(produto.getNome());
            dto.setValorInvestido(simulacao.getValor().doubleValue());
            dto.setValorFinal(simulacao.getValorFinal().doubleValue());
            dto.setPrazoMeses(simulacao.getPrazoMeses());
            dto.setDataSimulacao(simulacao.getDataSimulacao());
            return dto;
        }).toList();

        return simulacoesDTOList;
    }

    public List<ListarSimulacoesProdutoDiaResponseDTO> listarSimulacoesProdutoDia() {

        List<ListarSimulacoesProdutoDiaDTO> simulacoesAgrupadas = simulacaoRepository.findAllGroupedByProdutoAndDate();

        List<ListarSimulacoesProdutoDiaResponseDTO> responseDTO = Collections.synchronizedList(new java.util.ArrayList<>());

        for (ListarSimulacoesProdutoDiaDTO dto : simulacoesAgrupadas) {
            ProdutoEntity produto = produtoRepository.findById(dto.getProdutoId());

            ListarSimulacoesProdutoDiaResponseDTO responseItem = new ListarSimulacoesProdutoDiaResponseDTO();
            responseItem.setProduto(produto.getNome());
            responseItem.setData(dto.getData());
            responseItem.setQuantidadeSimulacoes(dto.getQuantidadeSimulacoes());
            responseItem.setMediaValorFinal(dto.getMediaValorFinal());

            responseDTO.add(responseItem);
        }

        return responseDTO;
    }

    public PerfilRiscoResponseDTO obterPerfilRisco(Long clienteId) {
        // Verifica se o cliente existe e possui simulações
        List<SimulacaoEntity> simulacoes = simulacaoRepository.find("clienteId", clienteId).list();
        // Verifica se o cliente possui simulações
        List<InvestimentoEntity> investimentos = investimentoRepository.findByClienteId(clienteId);

        if (simulacoes.isEmpty() && investimentos.isEmpty()) {
            return null;
        }
        // Calcula a pontuação do perfil de risco
        int pontuacaoPerfil =  recomendacaoService.calcularPontuacaoPerfilRisco(clienteId);

        return getPerfilRiscoResponseDTO(clienteId, pontuacaoPerfil);
    }

    private static PerfilRiscoResponseDTO getPerfilRiscoResponseDTO(Long clienteId, int pontuacaoPerfil) {
        PerfilRiscoResponseDTO perfilRisco = new PerfilRiscoResponseDTO();
        perfilRisco.setClienteId(clienteId);
        perfilRisco.setPontuacao(pontuacaoPerfil);

        if (pontuacaoPerfil >=10 && pontuacaoPerfil <=39) {
            perfilRisco.setPerfil("Conservador");
            perfilRisco.setDescricao("Perfil Conservador: Prefere segurança e estabilidade, evitando riscos elevados.");
        } else if (pontuacaoPerfil >=40 && pontuacaoPerfil <=69) {
            perfilRisco.setPerfil("Moderado");
            perfilRisco.setDescricao("Perfil Moderado: Busca um equilíbrio entre segurança e crescimento, aceitando riscos moderados.");
        } else {
            perfilRisco.setPerfil("Agressivo");
            perfilRisco.setDescricao("Perfil Agressivo: Está disposto a assumir riscos elevados em busca de maiores retornos.");
        }
        return perfilRisco;
    }


    public List<ProdutoValidadoDTO> obterProdutosRecomendados(String perfil) {

        if (Objects.equals(perfil.toUpperCase(), "MODERADO")) {
            return produtoRepository.findByPerfilRiscoModerado();
        }
        if (Objects.equals(perfil.toUpperCase(), "AGRESSIVO")) {
            return produtoRepository.findByPerfilRiscoAgressivo();
        }

        return produtoRepository.findByPerfilRiscoConservador();

    }
}
