package com.example.architecture.adapter.gateways.h2;

import com.example.architecture.adapter.gateways.mapper.CommonProductJpaMapper;
import com.example.architecture.adapter.repositories.ICommonProductRepository;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ICommonProductRegisterGateway;
import com.example.architecture.domain.entity.product.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonProductCreationH2Gateway implements ICommonProductRegisterGateway {

    @Autowired
    ICommonProductRepository iCommonProductRepository;

    @Override
    public void save(IProduct iProduct) {
        CommonProductJpaMapper commonProductJpaMapper = new CommonProductJpaMapper(
                iProduct.getID(),
                iProduct.getName(),
                iProduct.getDescription(),
                iProduct.getPrice(),
                iProduct.getCreatedAt());

        this.iCommonProductRepository.save(commonProductJpaMapper);

    }

    @Override
    public boolean existsById(String id) {
        return iCommonProductRepository.existsById(id);
    }
}
