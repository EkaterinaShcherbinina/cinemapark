package com.shcherbinina.cinemapark.exceptions.validationExceptions;

public class BusinessValidationException extends Exception{
    private String message;

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
}
