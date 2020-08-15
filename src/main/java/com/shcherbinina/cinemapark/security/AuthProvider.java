package com.shcherbinina.cinemapark.security;

import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.dto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        UserDTO user = userService.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String password = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
        Collection<? extends GrantedAuthority> authorities = user.getRoles();
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    public void updateUserName(UserNameDTO userDTO) {
        UserDTO user = authenticationFacade.getCurrentUser();
        if(user != null) {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
        }
    }

    public void updateUserEmail(UserEmailDTO email) {
        UserDTO user = authenticationFacade.getCurrentUser();
        if(user != null) {
            user.setEmail(email.getEmail());
        }
    }

    public void updateUserPassword(UserPasswordDTO userDTO) {
        UserDTO user = authenticationFacade.getCurrentUser();
        if(user != null) {
            user.setPassword(userDTO.getNewPassword());
        }
    }

    public void updateUserAccount(BigDecimal userAccount) {
        UserDTO user = authenticationFacade.getCurrentUser();
        if(user != null) {
            user.setAccount(userAccount);
        }
    }

    public boolean checkIfValidOldPassword(String currentPassword, String oldPassword) {
        return passwordEncoder.matches(oldPassword, currentPassword);
    }
}
