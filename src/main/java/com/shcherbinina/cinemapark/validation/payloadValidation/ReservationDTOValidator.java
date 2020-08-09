package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReservationDTOValidator implements Validator {
    private final String placeNotChosenError = "Place should be chosen";

    @Override
    public boolean supports(Class<?> aClass) {
        return ReservationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ReservationDTO reservationDTO = (ReservationDTO) o;
        if (reservationDTO.getPlace() == 0 || reservationDTO.getRowId() == 0) {
            errors.rejectValue("place", "", placeNotChosenError);
        }
    }
}
