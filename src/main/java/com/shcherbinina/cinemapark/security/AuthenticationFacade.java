package com.shcherbinina.cinemapark.security;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public UserDTO getCurrentUser() {
        UserDTO user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }

    @Override
    public int getCurrentUserId() {
        UserDTO user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            user = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user.getId();
        }
        return 0;
    }

    @Override
    public String getCurrentUserName() {
        String res;
        try {
            UserDTO userDTO = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            res = userDTO.getFirstName();
        } catch (ClassCastException ex) {
            res = null;
        }
        return res;
    }
}
