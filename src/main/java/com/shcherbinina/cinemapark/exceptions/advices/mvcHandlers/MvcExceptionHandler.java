package com.shcherbinina.cinemapark.exceptions.advices.mvcHandlers;

import com.shcherbinina.cinemapark.exceptions.errors.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MvcExceptionHandler {
    private String pageNotFound = "We can't find the page you looking for";

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            Model model) {
        ApiError error = new ApiError(pageNotFound, HttpStatus.NOT_FOUND);
        model.addAttribute("exception", error);
        return "exceptionPage";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected String handleNoHandlerFoundException(
            NoHandlerFoundException ex, Model model) {
        ApiError error = new ApiError(pageNotFound, HttpStatus.NOT_FOUND);
        model.addAttribute("exception", error);
        return "exceptionPage";
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected String handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex, Model model) {
        ApiError error = new ApiError(pageNotFound, HttpStatus.NOT_FOUND);
        model.addAttribute("exception", error);
        return "exceptionPage";
    }
}
