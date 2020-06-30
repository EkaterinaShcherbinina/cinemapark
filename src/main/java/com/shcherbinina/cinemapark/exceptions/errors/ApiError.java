package com.shcherbinina.cinemapark.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus status;
    private String message;

    private String debugMessage;

    public ApiError(HttpStatus status, String message, String debugMessage) {
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public ApiError(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}