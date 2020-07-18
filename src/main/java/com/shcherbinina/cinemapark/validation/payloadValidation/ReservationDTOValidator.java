package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import org.springframework.stereotype.Component;

@Component
public class ReservationDTOValidator implements IPayloadValidation{
    private final String placeNotChosenError = "Please choose a place";
    private final String invalidData = "Invalid input reservation data";

    @Override
    public void validate(Object dto) throws PayloadValidationException {
        ReservationDTO reservationDTO = (ReservationDTO) dto;
        if (reservationDTO.getPlace() == 0 || reservationDTO.getRowId() == 0) {
            throw new PayloadValidationException(placeNotChosenError);
        }

        if(reservationDTO.getSessionId() == 0 || reservationDTO.getUserId() == 0) {
            throw new PayloadValidationException(invalidData);
        }
    }
}
