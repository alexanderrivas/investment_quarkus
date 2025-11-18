package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.ProdutoEntity;

import java.util.List;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepositoryBase<ProdutoEntity, Integer> {

    //Implement find by tipo produto
    public List<ProdutoEntity> findByTipoProduto(String tipoProduto) {
        return find("tipo", tipoProduto).list();
    }

}
