package com.example.architecture.application.usecase.product.create.boundaries.input.register;

import com.example.architecture.application.usecase.product.create.model.request.CommonProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;

public interface ICommonProductRegisterBoundary {
    CommonProductResponseModel create(CommonProductRequestModel requestModel) throws ProductCustomException;
}
