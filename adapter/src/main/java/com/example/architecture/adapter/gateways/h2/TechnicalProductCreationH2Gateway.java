package com.example.architecture.adapter.gateways.h2;

import com.example.architecture.adapter.gateways.mapper.TechnicalProductJpaMapper;
import com.example.architecture.adapter.repositories.ITechnicalProductRepository;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.example.architecture.domain.entity.product.ITechnicalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TechnicalProductCreationH2Gateway implements ITechnicalProdutRegisterGateway {

    @Autowired
    ITechnicalProductRepository iTechnicalProductRepository;

    public TechnicalProductCreationH2Gateway() {
    }

    @Override
    public void save(ITechnicalProduct iProduct) {
        TechnicalProductJpaMapper technicalProductJpaMapper =
                new TechnicalProductJpaMapper(
                        iProduct.getID(),
                        iProduct.getName(),
                        iProduct.getDescription(),
                        iProduct.getPrice(),
                        iProduct.getCreatedAt(),
                        iProduct.getTechnicalInformation(),
                        iProduct.getInstructionManual());

        this.iTechnicalProductRepository.save(technicalProductJpaMapper);
    }

    @Override
    public boolean existsById(String id) {
        return iTechnicalProductRepository.existsById(id);
    }
}
