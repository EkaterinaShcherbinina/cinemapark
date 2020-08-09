package com.shcherbinina.cinemapark.exceptions.validationExceptions;

import org.springframework.http.HttpStatus;

public class BusinessValidationException extends Exception{
    private String message;
    private final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BusinessValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
