package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOValidator implements IPayloadValidation{
    @Autowired
    private UserService userService;

    private final String userExistMessage = "User with the same name already exists";
    private final String emptyFieldMessage = "Fill in all the fields";

    @Override
    public void validate(Object dto) throws PayloadValidationException {
        UserDTO user = (UserDTO) dto;

        if(userService.getByEmail(((UserDTO) dto).getEmail()) != null) {
            throw new PayloadValidationException(userExistMessage);
        }
    }
}
