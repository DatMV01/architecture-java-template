package com.example.architecture.domain.entity.product;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface IProduct {

    String getName();

    String getDescription();

    LocalDateTime getCreatedAt();

    double getPrice();

    boolean isNameValid();

    String getID();
}
