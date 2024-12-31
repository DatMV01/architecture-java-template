package com.example.architecture.domain.entity;

import java.time.ZonedDateTime;
import java.util.Objects;

public abstract class BaseEntity<ID> {
    private final ZonedDateTime createdAt = ZonedDateTime.now();
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
