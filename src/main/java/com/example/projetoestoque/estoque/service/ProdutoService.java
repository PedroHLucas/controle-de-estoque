package com.example.projetoestoque.estoque.service;

import com.example.projetoestoque.estoque.entities.Categoria;
import com.example.projetoestoque.estoque.entities.Produto;
import com.example.projetoestoque.estoque.exceptions.CategoriaNotFoundedException;
import com.example.projetoestoque.estoque.repository.CategoriaRepository;
import com.example.projetoestoque.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;


    public Produto salvarProduto(String name, Long categoriaId){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("nome é obrigatório");
        }
        if (categoriaId == null) {
            throw new IllegalArgumentException("categoriaId é obrigatório");
        }

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada com id: " + categoriaId));

        Produto produto = new Produto();
        produto.setNome(name);
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, String name, Long categoriaId){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id));

        if (name != null && !name.trim().isEmpty()) {
            produto.setNome(name);
        }

        if (categoriaId != null) {
            Categoria categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada com id: " + categoriaId));
            produto.setCategoria(categoria);
        }
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id));
        produtoRepository.delete(produto);
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com id: " + id));
    }

    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public List<Produto> listarProdutosPorCategoria(Long categoriaId){
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNotFoundedException("Categoria não encontrada com id: " + categoriaId));
        return produtoRepository.findByCategoria(categoria);
    }
}
