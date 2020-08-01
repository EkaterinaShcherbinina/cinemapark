package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AccountEditDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;

public interface IUserService {
    UserDTO getById(int userId);
    UserDTO getByEmail(String email);
    void addNewUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    AccountEditDTO getUserAccountById(int userId);
    void updateUserAccount(AccountEditDTO userDTO);
}
