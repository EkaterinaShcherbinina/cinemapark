package com.shcherbinina.cinemapark.validation;

import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import org.springframework.validation.BindingResult;

public class ValidationHelper {
    public static void checkErrors(BindingResult bindingResult) throws PayloadValidationException {
        if(bindingResult.hasErrors()) throw new PayloadValidationException(bindingResult);
    }
}
