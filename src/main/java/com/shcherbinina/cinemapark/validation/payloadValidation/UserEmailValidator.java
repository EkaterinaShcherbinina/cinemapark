package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.entity.UserEmailDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserEmailValidator implements Validator {
    private final String emailExistMessage = "User with the same email already exists";
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEmailDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEmailDTO email = (UserEmailDTO)o;
        UserDTO user = userService.getByEmail(email.getEmail());
        if(user != null && user.getEmail().equals(email.getEmail()))
            errors.rejectValue("email", "", emailExistMessage);
    }
}
