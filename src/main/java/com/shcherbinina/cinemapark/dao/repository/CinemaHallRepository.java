package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends CrudRepository<CinemaHall, Integer> {
    CinemaHall findById(int hallId);
    CinemaHall findByHallName(String hallName);
}
