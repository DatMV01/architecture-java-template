package com.example.architecture.application.usecase.product.create.presenter;

import com.example.architecture.application.usecase.product.create.model.response.TechnicalProductResponseModel;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;

public interface ITechnicalProductPresenter {

    TechnicalProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException;
    TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel);
}
