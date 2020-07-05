package com.shcherbinina.cinemapark.exceptions.errors;

import org.springframework.http.HttpStatus;

public class BadRequestError {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message = "The bad request";

    public BadRequestError() {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
