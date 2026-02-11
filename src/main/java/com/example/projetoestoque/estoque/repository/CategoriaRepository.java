package com.example.projetoestoque.estoque.repository;

import com.example.projetoestoque.estoque.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
