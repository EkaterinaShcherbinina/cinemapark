package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.*;

public interface IUserService {
    UserDTO getById(int userId);
    UserDTO getByEmail(String email);
    void addNewUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    UserNameDTO getUserNameById(int userId);
    UserEmailDTO getUserEmailById(int userId);
    void updateUserName(UserNameDTO userDTO);
    void updateUserPassword(UserPasswordDTO userDTO);
    void updateUserEmail(UserEmailDTO email);
}
