package com.shcherbinina.cinemapark.exceptions.advices;

import com.shcherbinina.cinemapark.exceptions.errors.ApiError;
import com.shcherbinina.cinemapark.exceptions.errors.BadRequestError;
import com.shcherbinina.cinemapark.exceptions.errors.PageNotFoundError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRunTimeException(RuntimeException e) {
        return new ResponseEntity<>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        BadRequestError badRequestError = new BadRequestError();
        return new ResponseEntity(badRequestError, badRequestError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        BadRequestError badRequestError = new BadRequestError();
        return new ResponseEntity(badRequestError, badRequestError.getStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest request) {
        PageNotFoundError error = new PageNotFoundError();
        return new ResponseEntity<>(error, error.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        PageNotFoundError error = new PageNotFoundError();
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Exception", ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
