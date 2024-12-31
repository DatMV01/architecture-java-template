package com.example.architecture.domain.event.publisher;

import com.example.architecture.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
