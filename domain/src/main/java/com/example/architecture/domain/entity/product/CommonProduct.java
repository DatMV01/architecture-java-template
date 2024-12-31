package com.example.architecture.domain.entity.product;



import com.example.architecture.domain.entity.AggregateRoot;
import com.example.architecture.domain.valueobject.ProductId;

import java.util.UUID;

public class CommonProduct extends AggregateRoot<ProductId> implements IProduct {
    private static final int MINIMUM_CHARACTER_LIMIT = 5;
    private String name;
    private String description;
    private double price;

    public CommonProduct(ProductId productId) {
        super.setId(productId);
    }

    public CommonProduct(ProductId productId, String name, String description, double price) {
        this.setId(productId);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public CommonProduct(String name, String description, double price) {
        this.setId(new ProductId(UUID.randomUUID()));
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean isNameValid() {
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }

    @Override
    public String getID() {
        return this.getId().toString();
    }


}
