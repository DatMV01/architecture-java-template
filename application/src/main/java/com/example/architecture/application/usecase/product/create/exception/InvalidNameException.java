package com.example.architecture.application.usecase.product.create.exception;

public class InvalidNameException extends ProductCustomException {
    public InvalidNameException(String message) {
        super(message);
    }

}
