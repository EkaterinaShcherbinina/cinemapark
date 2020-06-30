package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;

public interface IUserRepository {
    User getUserById(int userId);
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
}
