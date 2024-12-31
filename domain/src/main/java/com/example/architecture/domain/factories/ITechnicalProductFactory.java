package com.example.architecture.domain.factories;

import com.example.architecture.domain.entity.product.ITechnicalProduct;

import java.util.UUID;

public interface ITechnicalProductFactory {
    ITechnicalProduct create(String name, String description, double price, String technicalInformation, String instructionManual);

    ITechnicalProduct create(UUID uuid, String name, String description, double price, String technicalInformation, String instructionManual);
}
