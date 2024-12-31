package com.example.architecture.domain.factories;

import com.example.architecture.domain.entity.product.ITechnicalProduct;
import com.example.architecture.domain.entity.product.TechnicalProduct;

import java.util.UUID;

public class TechnicalProductFactory implements ITechnicalProductFactory {
    @Override
    public TechnicalProduct create(String name, String description, double price, String technicalInformation, String instructionManual) {
        return new TechnicalProduct(name, description, price, technicalInformation, instructionManual);
    }

    @Override
    public ITechnicalProduct create(UUID uuid, String name, String description, double price, String technicalInformation, String instructionManual) {
        return new TechnicalProduct(uuid, name, description, price, technicalInformation, instructionManual);
    }
}
