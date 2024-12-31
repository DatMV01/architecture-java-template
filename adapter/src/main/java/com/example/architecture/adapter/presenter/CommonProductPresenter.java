package com.example.architecture.adapter.presenter;

import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import com.example.architecture.application.usecase.product.create.presenter.ICommonProductPresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonProductPresenter implements ICommonProductPresenter {
    @Override
    public CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException {
        throw e;
    }

    @Override
    public CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreatedAt());
        responseModel.setCreatedAt(responseTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return responseModel;
    }
}
