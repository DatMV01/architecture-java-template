package com.example.architecture.mainapp.beanconfigs;

import com.example.architecture.adapter.gateways.h2.TechnicalProductCreationH2Gateway;
import com.example.architecture.adapter.presenter.TechnicalProductPresenter;
import com.example.architecture.application.usecase.product.create.boundaries.input.register.ITechnicalProductRegisterBoundary;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.example.architecture.application.usecase.product.create.interactors.TechnicalProductInteractor;
import com.example.architecture.application.usecase.product.create.presenter.ITechnicalProductPresenter;
import com.example.architecture.domain.factories.ITechnicalProductFactory;
import com.example.architecture.domain.factories.TechnicalProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TechnicalProductConfiguration {
    @Bean
    public ITechnicalProductPresenter technicalProductPresenter() {
        return new TechnicalProductPresenter();
    }

    @Bean
    public ITechnicalProductFactory technicalProductFactory() {
        return new TechnicalProductFactory();
    }

    @Bean
    public ITechnicalProdutRegisterGateway technicalProdutRegisterGateway() {
        return new TechnicalProductCreationH2Gateway();
    }

    @Bean
    public ITechnicalProductRegisterBoundary technicalProductInputBoundary(
            @Autowired ITechnicalProductPresenter technicalProductPresenter,
            @Autowired ITechnicalProductFactory technicalProductFactory,
            @Autowired ITechnicalProdutRegisterGateway technicalProdutRegisterGateway) {
        return new TechnicalProductInteractor(technicalProductFactory, technicalProductPresenter, technicalProdutRegisterGateway);
    }


}
