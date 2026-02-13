package com.example.projetoestoque.estoque.test;


import com.example.projetoestoque.estoque.entities.Categoria;
import com.example.projetoestoque.estoque.entities.Produto;
import com.example.projetoestoque.estoque.repository.CategoriaRepository;
import com.example.projetoestoque.estoque.repository.ProdutoRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class estoqueTest implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception{

        Categoria cat = new Categoria();
        cat.setName("Domestico");
        categoriaRepository.save(cat);

        Produto prod = new Produto();
        prod.setNome("Geladeira");
        prod.setDescricao("Uso Cotidiano");
        prod.setPreco(1300.0);
        prod.setQuantidade_estoque(12);
        prod.setCategoria(cat);

        Produto salvo = produtoRepository.save(prod);

        System.out.println(">>> SUCESSO: Produto " + prod.getNome() + " salvo com a categoria " + cat.getName());



    }

}
