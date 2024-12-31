package com.example.architecture.domain.valueobject;

import java.util.UUID;

public class TechnicalProductId extends BaseId<UUID> {
    public TechnicalProductId(UUID value) {
        super(value);
    }
}
