package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;

public interface IUserService {
    void addNewUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
}
