package com.example.projetoestoque.estoque.exceptions;

public class ProductNotFoundedException extends RuntimeException{

    public ProductNotFoundedException(String message) {
        super(message);
    }

}
