package com.example.architecture.application.usecase.product.create.boundaries.input.register;

import com.example.architecture.application.usecase.product.create.model.request.TechnicalProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.TechnicalProductResponseModel;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;

public interface ITechnicalProductRegisterBoundary {
    TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws ProductCustomException;
}
