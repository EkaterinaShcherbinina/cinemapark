package com.shcherbinina.cinemapark.exceptions.errors;

import org.springframework.validation.Errors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationError {
    private List<String> errors;
    private String timestamp;
    private String message;

    public ValidationError(String message, Errors errors) {
        this.message = message;
        this.errors = errors
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        timestamp = LocalDateTime.now().toString();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
