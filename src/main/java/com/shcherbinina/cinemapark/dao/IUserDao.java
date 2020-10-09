package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;

public interface IUserDao {
    User getUserById(int userId);
    User getUserByEmail(String email);
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
}
