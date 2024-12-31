package com.example.architecture.application.usecase.product.create.boundaries.output.register;

public interface IProductExistsGateway {
    boolean existsById(String id);
}
