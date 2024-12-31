package com.example.architecture.adapter.repositories;


import com.example.architecture.adapter.gateways.mapper.TechnicalProductJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITechnicalProductRepository extends JpaRepository<TechnicalProductJpaMapper, String> {
}
