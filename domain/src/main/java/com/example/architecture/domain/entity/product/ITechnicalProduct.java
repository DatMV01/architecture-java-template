package com.example.architecture.domain.entity.product;

public interface ITechnicalProduct extends IProduct {
    String getTechnicalInformation();

    String getInstructionManual();

    boolean isTechnicalInformationValid();
}
