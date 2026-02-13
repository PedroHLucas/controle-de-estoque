package com.example.projetoestoque.estoque.repository;

import com.example.projetoestoque.estoque.entities.Categoria;
import com.example.projetoestoque.estoque.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoria);
}
