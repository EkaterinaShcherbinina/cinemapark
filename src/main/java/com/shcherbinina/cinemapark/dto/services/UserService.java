package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.Role;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.AccountEditDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DTOConverter dtoConverter;

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
    public AccountEditDTO getUserAccountById(int userId) {
        return dtoConverter.convertToUserAccountDTO(userRepository.getUserById(userId));
    }

    @Override
    public void updateUserAccount(AccountEditDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUserAccount(userDTO));
    }
}
