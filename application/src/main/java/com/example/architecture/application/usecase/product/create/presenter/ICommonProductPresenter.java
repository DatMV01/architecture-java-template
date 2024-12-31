package com.example.architecture.application.usecase.product.create.presenter;

import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;

public interface ICommonProductPresenter {
    CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException;
    CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel);
}
