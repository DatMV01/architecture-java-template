package com.example.architecture.domain.entity.product;

import java.time.ZonedDateTime;

public interface IProduct {

    String getName();

    String getDescription();

    ZonedDateTime getCreatedAt();

    double getPrice();

    boolean isNameValid();

    String getID();
}