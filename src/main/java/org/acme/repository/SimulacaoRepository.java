package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.ListarSimulacoesProdutoDiaDTO;
import org.acme.entities.local.SimulacaoEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SimulacaoRepository implements PanacheRepositoryBase<SimulacaoEntity, Long> {

    public List<ListarSimulacoesProdutoDiaDTO> findAllGroupedByProdutoAndDate() {
        List<Object[]> rows = getEntityManager().createQuery(
                "SELECT s.produtoId, CAST(s.dataSimulacao AS date), COUNT(s), AVG(s.valorFinal) " +
                        "FROM SimulacaoEntity s " +
                        "GROUP BY s.produtoId, CAST(s.dataSimulacao AS date)",
                Object[].class
        ).getResultList();

        return rows.stream()
                .map(r -> {
                    Integer produtoId = (Integer) r[0];
                    Date data = (Date) r[1];
                    Long quantidade = (Long) r[2];

                    Object avgObj = r[3];
                    BigDecimal media;
                    if (avgObj instanceof BigDecimal) {
                        media = (BigDecimal) avgObj;
                    } else if (avgObj instanceof Number) {
                        media = BigDecimal.valueOf(((Number) avgObj).doubleValue());
                    } else {
                        media = null;
                    }

                    return new ListarSimulacoesProdutoDiaDTO(
                            produtoId,
                            data,
                            quantidade,
                            media
                    );
                })
                .collect(Collectors.toList());

    }
    
}
