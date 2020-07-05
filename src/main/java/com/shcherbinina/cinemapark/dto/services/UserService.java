package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.UserDAO;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DTOConverter dtoConverter;

    public void addNewUser(UserDTO userDTO) {
        userRepository.addUser(dtoConverter.convertToUser(userDTO));
    }

    public void updateUser(UserDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUser(userDTO));
    }
}
