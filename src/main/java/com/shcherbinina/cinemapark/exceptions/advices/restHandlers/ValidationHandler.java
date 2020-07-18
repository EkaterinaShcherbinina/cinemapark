package com.shcherbinina.cinemapark.exceptions.advices.restHandlers;

import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice("com.shcherbinina.cinemapark.restControllers")
public class ValidationHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<Object> handleBusinessValidationException(BusinessValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PayloadValidationException.class)
    public ResponseEntity<Object> handlePayloadValidationException(PayloadValidationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
