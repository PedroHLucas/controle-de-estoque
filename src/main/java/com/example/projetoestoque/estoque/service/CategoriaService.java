package com.example.projetoestoque.estoque.service;


import com.example.projetoestoque.estoque.entities.Categoria;
import com.example.projetoestoque.estoque.exceptions.CategoriaNotFoundedException;
import com.example.projetoestoque.estoque.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Long buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada"));
        return categoria.getId();
    }
    public void salvarCategoria(String name){
            Categoria categoria = new Categoria();
            categoria.setName(name);
            categoriaRepository.save(categoria);
    }
    public void atualizarCategoria(Long id, String name){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada"));
        categoria.setName(name);
        categoriaRepository.save(categoria);
    }
    public void deletarCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada"));
        categoriaRepository.delete(categoria);
    }

}
