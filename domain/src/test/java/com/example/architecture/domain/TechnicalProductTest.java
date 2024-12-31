package com.example.architecture.domain;

import com.example.architecture.domain.entity.product.TechnicalProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechnicalProductTest {

    @Test
    void givenEmptyTechnicalInformation_whenTechnicalInformationIsNotValid_thenIsFalse() {
        TechnicalProduct technicalProduct = new TechnicalProduct(
                "Name",
                "Descr",
                50.0d,
                "abc",
                "Instructions"
        );

        assertTrue(technicalProduct.isTechnicalInformationValid());
    }

    @Test
    void givenAbcTechnicalInformation_whenTechnicalInformationIsValid_thenIsTrue() {
        TechnicalProduct technicalProduct = new TechnicalProduct(
                "ValidName",
                "Descr",
                50.0d,
                "Some technical details",
                "Instructions");

        assertTrue(technicalProduct.isTechnicalInformationValid());
    }

}
