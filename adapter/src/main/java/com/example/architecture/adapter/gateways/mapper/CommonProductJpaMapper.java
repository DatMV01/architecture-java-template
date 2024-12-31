package com.example.architecture.adapter.gateways.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Entity
@Table(name = "common_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonProductJpaMapper {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private LocalDateTime createdAt;
}
