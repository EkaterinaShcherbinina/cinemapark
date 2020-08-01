package com.shcherbinina.cinemapark.dto.entity;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class UserInfo {
    private String userName;
    private Collection userRole;

    public UserInfo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != "anonymousUser") {
            UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userName = userDTO.getFirstName();
            userRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        }
    }

    public String getUserName() {
        return userName;
    }

    public Collection getUserRole() {
        return userRole;
    }
}
