package com.shcherbinina.cinemapark.security;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();
    UserDTO getCurrentUser();
    int getCurrentUserId();
}
