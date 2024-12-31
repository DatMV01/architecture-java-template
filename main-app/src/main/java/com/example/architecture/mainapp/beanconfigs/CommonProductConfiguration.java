package com.example.architecture.mainapp.beanconfigs;

import com.example.architecture.adapter.gateways.h2.CommonProductCreationH2Gateway;
import com.example.architecture.adapter.presenter.CommonProductPresenter;
import com.example.architecture.application.usecase.product.create.boundaries.input.register.ICommonProductRegisterBoundary;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ICommonProductRegisterGateway;
import com.example.architecture.application.usecase.product.create.interactors.CommonProductInteractor;
import com.example.architecture.application.usecase.product.create.presenter.ICommonProductPresenter;
import com.example.architecture.domain.factories.CommonProductFactory;
import com.example.architecture.domain.factories.ICommonProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonProductConfiguration {
    @Bean
    public ICommonProductPresenter commonProductPresenter() {
        return new CommonProductPresenter();
    }

    @Bean
    public ICommonProductFactory commonProductFactory() {
        return new CommonProductFactory();
    }

    @Bean
    public ICommonProductRegisterGateway commonProductRegisterGateway() {
        return new CommonProductCreationH2Gateway();
    }

    @Bean
    public ICommonProductRegisterBoundary commonProductInputBoundary(
            @Autowired ICommonProductPresenter commonProductPresenter,
            @Autowired ICommonProductFactory commonProductFactory,
            @Autowired ICommonProductRegisterGateway commonProductRegisterGateway) {
        return new CommonProductInteractor(commonProductPresenter, commonProductFactory, commonProductRegisterGateway);
    }
}
