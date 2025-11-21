package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.mssql.ProdutoEntity;
import org.acme.repository.ProdutoRepository;

import java.util.List;

@ApplicationScoped
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Método para buscar todos os produtos
    public List<ProdutoEntity> listarTodosProdutos() {
        return repository.listAll();
    }

}
