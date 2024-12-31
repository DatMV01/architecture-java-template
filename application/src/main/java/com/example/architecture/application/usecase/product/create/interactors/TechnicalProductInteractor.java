package com.example.architecture.application.usecase.product.create.interactors;

import com.example.architecture.application.usecase.product.create.model.request.TechnicalProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.TechnicalProductResponseModel;
import com.example.architecture.application.usecase.product.create.boundaries.input.register.ITechnicalProductRegisterBoundary;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.example.architecture.application.usecase.product.create.exception.InvalidNameException;
import com.example.architecture.application.usecase.product.create.exception.InvalidTechnicalInformationException;
import com.example.architecture.application.usecase.product.create.exception.ProductAlreadyExistsException;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.presenter.ITechnicalProductPresenter;
import com.example.architecture.domain.entity.product.ITechnicalProduct;
import com.example.architecture.domain.factories.ITechnicalProductFactory;

import java.util.UUID;

public class TechnicalProductInteractor implements ITechnicalProductRegisterBoundary {

    ITechnicalProductFactory factory;
    ITechnicalProductPresenter presenter;
    ITechnicalProdutRegisterGateway gateway;

    public TechnicalProductInteractor(ITechnicalProductFactory factory, ITechnicalProductPresenter presenter, ITechnicalProdutRegisterGateway gateway) {
        this.factory = factory;
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsById(requestModel.getId())) {
            return presenter.prepareFailView(
                    new ProductAlreadyExistsException(
                            "TechnicalProduct with id " + requestModel.getId() + " already in database"));
        }

        ITechnicalProduct technicalProduct = factory.create(
                UUID.fromString(requestModel.getId()),
                requestModel.getName(),
                requestModel.getDescription(),
                requestModel.getPrice(),
                requestModel.getTechnicalInformation(),
                requestModel.getInstructionManual());

        if (!technicalProduct.isNameValid()) {
            return presenter.prepareFailView(
                    new InvalidNameException("Name " + technicalProduct.getName() + " is not valid"));
        }

        if (!technicalProduct.isTechnicalInformationValid()) {
            return presenter.prepareFailView(
                    new InvalidTechnicalInformationException("Technical information " +
                            technicalProduct.getTechnicalInformation() + " is not valid"));
        }

        gateway.save(technicalProduct);

        TechnicalProductResponseModel responseModel = new TechnicalProductResponseModel(
                technicalProduct.getID(),
                technicalProduct.getName(),
                technicalProduct.getDescription(),
                technicalProduct.getPrice(),
                requestModel.getTechnicalInformation(),
                requestModel.getInstructionManual(),
                String.valueOf(technicalProduct.getCreatedAt()));

        return presenter.prepareSuccessView(responseModel);
    }
}
