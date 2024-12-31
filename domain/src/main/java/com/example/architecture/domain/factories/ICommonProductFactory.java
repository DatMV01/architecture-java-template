package com.example.architecture.domain.factories;

import com.example.architecture.domain.entity.product.IProduct;

public interface ICommonProductFactory {
    IProduct create(String id, String name, String description, double price);
}
