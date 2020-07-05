package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.UserDAO;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserById(int userId) {
        return userDAO.findById(userId);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userDAO.deleteById(userId);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        addUser(user);
    }
}
