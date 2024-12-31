package com.example.architecture.application.usecase.product.create.interactors;

import com.example.architecture.application.usecase.product.create.model.request.CommonProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import com.example.architecture.application.usecase.product.create.boundaries.input.register.ICommonProductRegisterBoundary;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ICommonProductRegisterGateway;
import com.example.architecture.application.usecase.product.create.exception.InvalidNameException;
import com.example.architecture.application.usecase.product.create.exception.ProductAlreadyExistsException;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.presenter.ICommonProductPresenter;
import com.example.architecture.domain.entity.product.IProduct;
import com.example.architecture.domain.factories.ICommonProductFactory;

public class CommonProductInteractor implements ICommonProductRegisterBoundary {

    ICommonProductPresenter presenter;
    ICommonProductFactory factory;
    ICommonProductRegisterGateway gateway;

    public CommonProductInteractor(ICommonProductPresenter presenter, ICommonProductFactory factory, ICommonProductRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public CommonProductResponseModel create(CommonProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsById(requestModel.getId())) {
            return presenter.prepareFailView(new ProductAlreadyExistsException("Product with id " + requestModel.getId() + " already in database"));
        }
        IProduct commonProduct = factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice());

        if (!commonProduct.isNameValid()) {
            return presenter.prepareFailView(new InvalidNameException("Name " + commonProduct.getName() + " is not valid"));
        }

        gateway.save(commonProduct);

        CommonProductResponseModel responseModel = new CommonProductResponseModel(commonProduct.getID(), commonProduct.getName(), commonProduct.getDescription(), commonProduct.getPrice(), String.valueOf(commonProduct.getCreatedAt()));

        return presenter.prepareSuccessView(responseModel);
    }
}
