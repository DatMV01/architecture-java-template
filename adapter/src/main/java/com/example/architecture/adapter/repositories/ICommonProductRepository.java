package com.example.architecture.adapter.repositories;

import com.example.architecture.adapter.gateways.mapper.CommonProductJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICommonProductRepository extends JpaRepository<CommonProductJpaMapper, String> {
}
