package com.example.architecture.mainapp.controller;
 import com.example.architecture.application.usecase.product.create.boundaries.input.register.ITechnicalProductRegisterBoundary;
 import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
 import com.example.architecture.application.usecase.product.create.model.request.TechnicalProductRequestModel;
 import com.example.architecture.application.usecase.product.create.model.response.TechnicalProductResponseModel;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technicalProduct")
public class TechnicalProductRegisterController {
    ITechnicalProductRegisterBoundary inputBoundary;

    public TechnicalProductRegisterController(ITechnicalProductRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public TechnicalProductResponseModel create(@RequestBody TechnicalProductRequestModel requestModel) throws ProductCustomException {
        return inputBoundary.create(requestModel);
    }
}
