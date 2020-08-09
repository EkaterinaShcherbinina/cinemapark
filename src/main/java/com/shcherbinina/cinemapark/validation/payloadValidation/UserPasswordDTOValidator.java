package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.entity.UserPasswordDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.security.AuthProvider;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserPasswordDTOValidator implements Validator {
    private final String invalidPasswordMessage = "Wrong current password";
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private AuthProvider authProvider;
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserPasswordDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserPasswordDTO dto = (UserPasswordDTO) o;
        UserDTO user = userService.getById(authenticationFacade.getCurrentUserId());

        if (!authProvider.checkIfValidOldPassword(user.getPassword(), dto.getOldPassword())) {
            errors.rejectValue("oldPassword", "", invalidPasswordMessage);
        }
    }
}
