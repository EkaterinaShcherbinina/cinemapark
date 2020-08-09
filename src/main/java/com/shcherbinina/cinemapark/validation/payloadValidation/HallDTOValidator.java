package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.google.common.base.Strings.isNullOrEmpty;

@Component
public class HallDTOValidator implements Validator {
    private String placeErrorMessage = "Invalid input format";
    private String emptyPlaceErrorMessage = "Place field mustn't be empty";

    @Override
    public boolean supports(Class<?> aClass) {
        return CinemaHallDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CinemaHallDTO dto = (CinemaHallDTO) o;
        String[] places = dto.getPlacesAmountInRow();
        for (int i = 0; i < places.length; i++) {
            String val = places[i];
            if (!isNullOrEmpty(val)) {
                try {
                    if (Integer.parseInt(val) > 0) continue;
                } catch(NumberFormatException ex) {
                    errors.rejectValue("placesAmountInRow[" + i + "]", "", placeErrorMessage);
                }
            }
            errors.rejectValue("placesAmountInRow[" + i + "]", "", emptyPlaceErrorMessage);
            break;
        }
    }
}
