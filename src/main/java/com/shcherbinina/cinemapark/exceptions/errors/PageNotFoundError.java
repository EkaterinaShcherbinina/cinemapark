package com.shcherbinina.cinemapark.exceptions.errors;

import org.springframework.http.HttpStatus;

public class PageNotFoundError {
    private HttpStatus status = HttpStatus.NOT_FOUND;
    private String message = "We can't find the page you looking for";

    public PageNotFoundError() {
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
