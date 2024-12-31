package com.example.architecture.domain.factories;

import com.example.architecture.domain.entity.product.CommonProduct;
 
public class CommonProductFactory implements ICommonProductFactory {

    @Override
    public CommonProduct create(String id, String name, String description, double price) {
        return new CommonProduct(name, description, price);
    }
}
