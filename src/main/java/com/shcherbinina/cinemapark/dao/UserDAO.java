package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
    User findById(int userId);
}
