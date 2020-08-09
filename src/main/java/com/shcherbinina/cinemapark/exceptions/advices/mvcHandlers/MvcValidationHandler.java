package com.shcherbinina.cinemapark.exceptions.advices.mvcHandlers;

import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice("com.shcherbinina.cinemapark.mvcControllers")
public class MvcValidationHandler {
    @ExceptionHandler(BusinessValidationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException (BusinessValidationException exception, Model model) {
        model.addAttribute("exception", exception);
        return "exceptionPage";
    }
}
