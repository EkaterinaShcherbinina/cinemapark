package com.shcherbinina.cinemapark.validation.businessValidation;

import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;

public interface IBusinessValidation {
    void validate(Object obj) throws BusinessValidationException;
}
