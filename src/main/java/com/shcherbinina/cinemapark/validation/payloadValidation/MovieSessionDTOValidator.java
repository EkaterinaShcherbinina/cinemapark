package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.google.common.base.Strings.isNullOrEmpty;

@Component
public class MovieSessionDTOValidator implements Validator {
    private final String costErrorMessage = "Invalid input for the cost field";

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminSessionDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AdminSessionDTO dto = (AdminSessionDTO) o;

        try {
            String costField = dto.getCost();
            if(!isNullOrEmpty(costField))
            Double.parseDouble(costField);
        } catch(NumberFormatException ex) {
            errors.rejectValue("cost", "", costErrorMessage);
        }
    }
}
