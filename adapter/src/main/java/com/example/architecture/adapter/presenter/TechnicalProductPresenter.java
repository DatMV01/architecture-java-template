package com.example.architecture.adapter.presenter;

import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.model.response.TechnicalProductResponseModel;
import com.example.architecture.application.usecase.product.create.presenter.ITechnicalProductPresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TechnicalProductPresenter implements ITechnicalProductPresenter {
    @Override
    public TechnicalProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException {
        throw e;
    }

    @Override
    public TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreatedAt());
        responseModel.setCreatedAt(responseTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return responseModel;
    }
}
