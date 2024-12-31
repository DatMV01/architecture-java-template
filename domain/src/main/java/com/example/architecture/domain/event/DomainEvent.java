package com.example.architecture.domain.event;

public interface DomainEvent<T> {
    void fire();
}
