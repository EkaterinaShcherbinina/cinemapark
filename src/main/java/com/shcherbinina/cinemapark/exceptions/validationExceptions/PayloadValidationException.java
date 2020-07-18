package com.shcherbinina.cinemapark.exceptions.validationExceptions;

public class PayloadValidationException extends Exception{
    private String message;

    public PayloadValidationException(String message) {
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
