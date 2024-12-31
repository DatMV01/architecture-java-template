package com.example.architecture.mainapp.controller;

import com.example.architecture.application.usecase.product.create.boundaries.input.register.ICommonProductRegisterBoundary;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.model.request.CommonProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commonProducts")
public class CommonProductRegisterController {
    ICommonProductRegisterBoundary inputBoundary;

    public CommonProductRegisterController(ICommonProductRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public CommonProductResponseModel create(@RequestBody CommonProductRequestModel requestModel) throws ProductCustomException {
        return this.inputBoundary.create(requestModel);
    }
}
