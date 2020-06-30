package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallDAO extends CrudRepository<CinemaHall, Integer> {
    CinemaHall findById(int hallId);
}
