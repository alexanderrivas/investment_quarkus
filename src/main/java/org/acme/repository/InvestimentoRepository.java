package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.mssql.InvestimentoEntity;

import java.util.List;

@ApplicationScoped
public class InvestimentoRepository implements PanacheRepositoryBase<InvestimentoEntity, Integer> {

    public List<InvestimentoEntity> findByClienteId(Long clientId) {
        return find("clienteId", clientId).list();
    }

    public int calcularMediaTransacoesDosUltimosDozeMeses(Long clienteId) {

        String query = "SELECT COUNT(i) * 1.0 / 12 FROM InvestimentoEntity i " +
                       "WHERE i.clienteId = ?1 " +
                       "AND i.data >= CURRENT_DATE - 12 MONTH";

        Number result = (Number) getEntityManager().createQuery(query)
                .setParameter(1, clienteId)
                .getSingleResult();
        return result != null ? result.intValue() : 0;
    }
}
