package com.example.architecture.application.usecase.product.create.boundaries.output.register;

import com.example.architecture.domain.entity.product.IProduct;

public interface ICommonProductRegisterGateway extends IProductExistsGateway{
    void save(IProduct iProduct);
}
