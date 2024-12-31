package com.example.architecture.application.usecase.product.create.exception;

public class ProductAlreadyExistsException extends ProductCustomException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }

}
