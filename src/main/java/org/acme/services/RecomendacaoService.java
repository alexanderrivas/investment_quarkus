package org.acme.services;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.mssql.InvestimentoEntity;
import org.acme.entities.local.SimulacaoEntity;
import org.acme.repository.InvestimentoRepository;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.SimulacaoRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@ApplicationScoped
public class RecomendacaoService {

    private final InvestimentoRepository investimentoRepository;
    private final ProdutoRepository produtoRepository;
    private final SimulacaoRepository simulacaoRepository;

    public RecomendacaoService(InvestimentoRepository investimentoRepository, ProdutoRepository produtoRepository, SimulacaoRepository simulacaoRepository) {
        this.investimentoRepository = investimentoRepository;
        this.produtoRepository = produtoRepository;
        this.simulacaoRepository = simulacaoRepository;
    }

    public double calcularPontuacaoCarteira(Long clienteId) {

        // Média ponderada baseada no R$ alocado em cada ativo.
        // e a classificacao de risco do produto.
        // Pontuação de Risco dos Produtos (1-10), adicionado ao produto para simplificar o cálculo
        List<InvestimentoEntity> listaInvestimentos = investimentoRepository.findByClienteId(clienteId);

        BigDecimal totalInvestido = BigDecimal.valueOf(0);
        BigDecimal totalRisco = BigDecimal.valueOf(0);
        for (InvestimentoEntity investimento : listaInvestimentos) {
            int pontuacaoRisco = investimento.getProduto().getPontuacaoRisco();
            totalRisco = totalRisco.add(BigDecimal.valueOf(pontuacaoRisco).multiply(investimento.getValor()));
            totalInvestido = totalInvestido.add(investimento.getValor());
        }

        return totalRisco.divide(totalInvestido, 2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calcularPontuacaoFrequenciaMovimentacao(Long clienteId) {
        /*
         Transações por Mês (Média 6 meses)      | Pontuação (1-10) | Perfil Implícito
         -------------------------------------------------------------------------------
         0   (Aporte único, sem vendas)         | 1                | Passivo / Conservador
         1-2 (Aportes mensais, "buy and hold")  | 3                | Passivo / Moderado
         3-5 (Aportes + rebalanceamento)        | 5                | Moderado
         6-10 (Rebalanceamento frequente)       | 7                | Ativo / Agressivo
         11+ (Swing trade / Day trade)          | 10               | Trader / Agressivo
        */

        int transacoesMensais = investimentoRepository.calcularMediaTransacoesDosUltimosDozeMeses(clienteId);
        if (transacoesMensais == 0) {
            return 1.0;
        } else if (transacoesMensais <= 2) {
            return 3.0;
        } else if (transacoesMensais <= 5) {
            return 5.0;
        } else if (transacoesMensais <= 10) {
            return 7.0;
        } else {
            return 10.0;
        }
    }

    public double calcularPontuacaoSimulacao(Long clienteId) {
        // Média dos riscos das simulações anteriores do cliente
        List<SimulacaoEntity> simulacoes = simulacaoRepository.find("clienteId", clienteId ).list();
        if (simulacoes.isEmpty()) {
            return 5.0; // Pontuação neutra se não houver simulações anteriores
        }

        // Calcula a média da pontuação de risco dos produtos simulados
        double totalRisco = 0.0;
        for (SimulacaoEntity simulacao : simulacoes) {
            totalRisco += produtoRepository.findById(simulacao.getProdutoId()).getPontuacaoRisco();
        }

        return totalRisco / simulacoes.size();

    }

    public int calcularPontuacaoPerfilRisco(Long clienteId) {
        double pontuacaoCarteira = calcularPontuacaoCarteira(clienteId);
        double pontuacaoFrequencia = calcularPontuacaoFrequenciaMovimentacao(clienteId);
        double pontuacaoSimulacao = calcularPontuacaoSimulacao(clienteId);

        // Média ponderada: Carteira (50%), Frequência (25%), Simulação (25%).
        double media = ((pontuacaoCarteira * 0.5) + (pontuacaoFrequencia * 0.25) + (pontuacaoSimulacao * 0.25)) * 10;
        return (int) Math.round(media);
    }

}
