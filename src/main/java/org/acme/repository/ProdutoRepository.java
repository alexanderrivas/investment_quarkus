package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dtos.ProdutoValidadoDTO;
import org.acme.entities.mssql.ProdutoEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepositoryBase<ProdutoEntity, Integer> {

    //Implement find by tipo produto
    public Optional<ProdutoEntity> findByTipoProduto(String tipoProduto) {
        return find("tipo", tipoProduto).firstResultOptional();
    }

    public List<ProdutoValidadoDTO> findByPerfilRiscoConservador() {
        String query = "SELECT new org.acme.dtos.ProdutoValidadoDTO(p.id, p.nome, p.tipo, p.rentabilidade, p.risco) " +
                       "FROM ProdutoEntity p " +
                       "WHERE p.risco = 'Baixo' OR p.risco = 'Medio'";
        return getEntityManager().createQuery(query, ProdutoValidadoDTO.class).getResultList();
    }

    public List<ProdutoValidadoDTO> findByPerfilRiscoModerado() {
        String query = "SELECT new org.acme.dtos.ProdutoValidadoDTO(p.id, p.nome, p.tipo, p.rentabilidade, p.risco) " +
                "FROM ProdutoEntity p " +
                "WHERE p.risco = 'Baixo' OR p.risco = 'Medio' OR p.risco = 'Alto' ";
        return getEntityManager().createQuery(query, ProdutoValidadoDTO.class).getResultList();
    }

    public List<ProdutoValidadoDTO> findByPerfilRiscoAgressivo() {
        String query = "SELECT new org.acme.dtos.ProdutoValidadoDTO(p.id, p.nome, p.tipo, p.rentabilidade, p.risco) " +
                "FROM ProdutoEntity p " +
                "WHERE p.risco = 'Medio' OR p.risco = 'Alto' ";
        return getEntityManager().createQuery(query, ProdutoValidadoDTO.class).getResultList();
    }
}
