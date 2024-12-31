package com.example.architecture.adapter.gateways.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "technical_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalProductJpaMapper {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private LocalDateTime createdAt;
    private String technicalInformation;
    private String instructionManual;

}
