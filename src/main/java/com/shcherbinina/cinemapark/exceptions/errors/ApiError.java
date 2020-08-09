package com.shcherbinina.cinemapark.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private String message;
    private HttpStatus status;


    public ApiError(String message, HttpStatus sttatus) {
        this.message = message;
        this.status = sttatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}