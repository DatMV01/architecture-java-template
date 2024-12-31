package com.example.architecture.domain;


import com.example.architecture.domain.entity.product.CommonProduct;
import com.example.architecture.domain.entity.product.IProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonProductTest {

    @Test
    public void test_givenAbcName_whenNameIsNotValid_thenIsFalse() {
        IProduct product = new CommonProduct(
                "Name",
                "description",
                0.5d);

        assertFalse(product.isNameValid());
    }

    @Test
    public void test_givenUUiName_whenNameIsNotValid_thenIsFalse() {
        IProduct product = new CommonProduct(
                "ValidName",
                "description", 0.5d);       ;

        assertTrue(product.isNameValid());
    }

}
