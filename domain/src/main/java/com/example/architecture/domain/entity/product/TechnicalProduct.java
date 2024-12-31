package com.example.architecture.domain.entity.product;

import com.example.architecture.domain.entity.AggregateRoot;
import com.example.architecture.domain.valueobject.TechnicalProductId;

import java.util.UUID;

public class TechnicalProduct extends AggregateRoot<TechnicalProductId> implements ITechnicalProduct {
    private String name;
    private String description;
    private double price;
    private String technicalInformation;
    private String instructionManual;

    public TechnicalProduct(TechnicalProductId technicalProductId) {
        super.setId(technicalProductId);
    }

    public TechnicalProduct(
            TechnicalProductId technicalProductId,
            String name, String description,
            double price, String technicalInformation, String instructionManual) {
        this.setId(technicalProductId);
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
    }

    public TechnicalProduct(String name, String description, double price, String technicalInformation, String instructionManual) {
        this.setId(new TechnicalProductId(UUID.randomUUID()));
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
    }

    public TechnicalProduct(UUID uuid, String name, String description, double price, String technicalInformation, String instructionManual) {
        this.setId(new TechnicalProductId(uuid));
        this.name = name;
        this.description = description;
        this.price = price;
        this.technicalInformation = technicalInformation;
        this.instructionManual = instructionManual;
    }

    @Override
    public String getID() {
        return this.getId().toString();
    }

    @Override
    public String getTechnicalInformation() {
        return this.technicalInformation;
    }

    @Override
    public String getInstructionManual() {
        return this.instructionManual;
    }

    @Override
    public boolean isTechnicalInformationValid() {
        return !this.technicalInformation.isEmpty();
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
        return name != null && name.length() > 5;
    }


}
