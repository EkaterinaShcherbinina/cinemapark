package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;

public interface IPayloadValidation {
    void validate(Object dto) throws PayloadValidationException;
}
