package com.example.architecture.application;

import com.example.architecture.application.usecase.product.create.model.request.CommonProductRequestModel;
import com.example.architecture.application.usecase.product.create.model.response.CommonProductResponseModel;
import com.example.architecture.application.usecase.product.create.boundaries.output.register.ICommonProductRegisterGateway;
import com.example.architecture.application.usecase.product.create.exception.InvalidNameException;
import com.example.architecture.application.usecase.product.create.exception.ProductAlreadyExistsException;
import com.example.architecture.application.usecase.product.create.exception.ProductCustomException;
import com.example.architecture.application.usecase.product.create.interactors.CommonProductInteractor;
import com.example.architecture.application.usecase.product.create.presenter.ICommonProductPresenter;
import com.example.architecture.domain.entity.product.CommonProduct;
import com.example.architecture.domain.factories.ICommonProductFactory;
import com.example.architecture.domain.valueobject.ProductId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

public class CommonProductInteractorTest {

    ICommonProductFactory mockedFactory;

    ICommonProductPresenter mockedPresenter;

    ICommonProductRegisterGateway mockedGateway;

    @BeforeEach
    void setup() {
        mockedGateway = Mockito.mock(ICommonProductRegisterGateway.class);
        mockedFactory = Mockito.mock(ICommonProductFactory.class);
        mockedPresenter = Mockito.mock(ICommonProductPresenter.class);
    }

    @Test
    void givenValidCommonProductProperties_whenCreate_thenSaveItAndPrepareSuccessView()
            throws ProductCustomException {
        // ARRANGE
        UUID PRODUCT_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");

        CommonProductRequestModel requestModel = new CommonProductRequestModel(
                "TestId",
                "ValidTestName",
                "Test description",
                52.2);

        CommonProduct product = new CommonProduct(new ProductId(PRODUCT_ID),
                "ValidName",
                "Some Description",
                25.25d);

        CommonProductResponseModel responseModel = new CommonProductResponseModel(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                String.valueOf(product.getCreatedAt()));

        CommonProductResponseModel finalResponseModel = new CommonProductResponseModel(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                "2022-11-16");

        Mockito.when(mockedGateway.existsById(requestModel.getId()))
                .thenReturn(false);

        Mockito.when(mockedFactory.create(
                        requestModel.getId(),
                        requestModel.getName(),
                        requestModel.getDescription(),
                        requestModel.getPrice()))
                .thenReturn(product);

        Mockito.when(mockedPresenter.prepareSuccessView(responseModel))
                .thenReturn(finalResponseModel);

        CommonProductInteractor interactor = new CommonProductInteractor(
                mockedPresenter, mockedFactory, mockedGateway);

        // ACT
        CommonProductResponseModel verifyResponseModel = interactor.create(requestModel);

        Mockito.verify(mockedGateway, Mockito.times(1))
                .save(product);

        Mockito.verify(mockedGateway, Mockito.times(1))
                .existsById(requestModel.getId());

        Mockito.verify(mockedPresenter, Mockito.times(1))
                .prepareSuccessView(responseModel);

        Assertions.assertEquals(finalResponseModel.getId(), verifyResponseModel.getId());
        Assertions.assertEquals(finalResponseModel.getName(), verifyResponseModel.getName());
        Assertions.assertEquals(finalResponseModel.getDescription(), verifyResponseModel.getDescription());
        Assertions.assertEquals(finalResponseModel.getPrice(), verifyResponseModel.getPrice());
        Assertions.assertEquals("2022-11-16", verifyResponseModel.getCreatedAt());
    }

    @Test
    void givenExistingProduct_whenCreate_thenPrepareFailView_withInvalidNameException()
            throws ProductCustomException {
        // ARRANGE
        UUID PRODUCT_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");

        CommonProductRequestModel requestModel = new CommonProductRequestModel(
                "TestId",
                "123",
                "Test description",
                52.2);

        CommonProduct product = new CommonProduct(
                new ProductId(PRODUCT_ID),
                "123",
                "Some Description",
                25.25d);

        Mockito.when(mockedGateway.existsById(requestModel.getId()))
                .thenReturn(false);

        Mockito.when(mockedFactory.create(
                        requestModel.getId(),
                        requestModel.getName(),
                        requestModel.getDescription(),
                        requestModel.getPrice()))
                .thenReturn(product);

        String expectedMessage = "Name 123 is not valid";

        InvalidNameException invalidNameException = new InvalidNameException(expectedMessage);

        Mockito.when(mockedPresenter.prepareFailView(invalidNameException))
                .thenThrow(invalidNameException);

        Exception failViewException = Assertions
                .assertThrows(InvalidNameException.class,
                        () -> mockedPresenter.prepareFailView(invalidNameException));

        // ACT
        CommonProductInteractor interactor = new CommonProductInteractor(
                mockedPresenter,
                mockedFactory,
                mockedGateway);
        interactor.create(requestModel);

        // ASSERT
        Assertions.assertTrue(failViewException.getMessage().contains(expectedMessage));

        Mockito.verify(mockedFactory, Mockito.times(1))
                .create(requestModel.getId(),
                        requestModel.getName(),
                        requestModel.getDescription(),
                        requestModel.getPrice());

        Mockito.verify(mockedGateway,
                        Mockito.times(1))
                .existsById(requestModel.getId());

        Mockito.verify(mockedPresenter,
                        Mockito.times(1))
                .prepareFailView(invalidNameException);
    }

    @Test
    void given123Name_whenCreate_thenPrepareFailView_withAlreadyContainsException() throws ProductCustomException {

        // ARRANGE
        UUID PRODUCT_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");

        CommonProductRequestModel requestModel = new CommonProductRequestModel(
                "TestId",
                "123",
                "Test description",
                52.2);

        CommonProduct product = new CommonProduct(
                new ProductId(PRODUCT_ID),
                "123",
                "Some Description",
                25.25d);

        Mockito.when(mockedGateway.existsById(requestModel.getId()))
                .thenReturn(true);

        Mockito.when(mockedFactory
                        .create(requestModel.getId(),
                                requestModel.getName(),
                                requestModel.getDescription(),
                                requestModel.getPrice()))
                .thenReturn(product);

        String expectedMessage = "Product with id 123 already in database";

        ProductAlreadyExistsException customProductException =
                new ProductAlreadyExistsException(expectedMessage);

        Mockito.when(mockedPresenter.prepareFailView(customProductException))
                .thenThrow(customProductException);

        Exception failViewException = Assertions
                .assertThrows(ProductCustomException.class,
                        () -> mockedPresenter.prepareFailView(customProductException));

        // ACT
        CommonProductInteractor interactor = new CommonProductInteractor(
                mockedPresenter,
                mockedFactory,
                mockedGateway);

        interactor.create(requestModel);

        // ASSERT
        Assertions.assertTrue(failViewException.getMessage().contains(expectedMessage));
        Mockito.verify(mockedGateway, Mockito.times(1))
                .existsById(requestModel.getId());
        Mockito.verify(mockedPresenter, Mockito.times(1))
                .prepareFailView(customProductException);

    }

}
