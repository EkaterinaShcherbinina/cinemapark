package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.Role;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DTOConverter dtoConverter;
    @Autowired
    private AuthProvider authProvider;

    @Override
    public UserDTO getById(int userId) {
        return dtoConverter.convertToUserDTO(userRepository.getUserById(userId));
    }

    @Override
    public UserDTO getByEmail(String email) {
        return dtoConverter.convertToUserDTO(userRepository.getUserByEmail(email));
    }

    public void addNewUser(UserDTO userDTO) {
        userDTO.setRoles(Collections.singleton(Role.USER));
        userRepository.addUser(dtoConverter.convertToUser(userDTO));
    }

    public void updateUser(UserDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUser(userDTO));
    }

    @Override
    public UserNameDTO getUserNameById(int userId) {
        return dtoConverter.convertToUserNameDTO(userRepository.getUserById(userId));
    }

    @Override
    public UserEmailDTO getUserEmailById(int userId) {
        return dtoConverter.convertToUserEmailDTO(userRepository.getUserById(userId));
    }

    @Override
    public void updateUserName(UserNameDTO userDTO) {
        authProvider.updateUserName(userDTO);
        userRepository.updateUser(dtoConverter.convertToUserForUserNameDTO(userDTO));
    }

    @Override
    public void updateUserPassword(UserPasswordDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUserForUserPasswordDTO(userDTO));
        authProvider.updateUserPassword(userDTO);
    }

    @Override
    public void updateUserEmail(UserEmailDTO email) {
        userRepository.updateUser(dtoConverter.convertToUserForUserEmail(email));
        authProvider.updateUserEmail(email);
    }
}
