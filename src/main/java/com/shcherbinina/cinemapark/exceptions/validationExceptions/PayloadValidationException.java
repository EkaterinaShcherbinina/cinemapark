package com.shcherbinina.cinemapark.exceptions.validationExceptions;

import org.springframework.validation.Errors;

public class PayloadValidationException extends Exception{
    private final String message = "Invalid input data";
    private Errors errors;

    public PayloadValidationException(Errors errors) {
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Errors getErrors() {
        return errors;
    }
}
