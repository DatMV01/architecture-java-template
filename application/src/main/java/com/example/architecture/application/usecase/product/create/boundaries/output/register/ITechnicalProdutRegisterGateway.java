package com.example.architecture.application.usecase.product.create.boundaries.output.register;

import com.example.architecture.domain.entity.product.ITechnicalProduct;

public interface ITechnicalProdutRegisterGateway extends IProductExistsGateway{
    void save(ITechnicalProduct iTechnicalProduct);
}
