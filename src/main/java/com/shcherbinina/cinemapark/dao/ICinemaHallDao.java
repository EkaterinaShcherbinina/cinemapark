package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;

import java.util.List;

public interface ICinemaHallDao {
    CinemaHall getCinemaHallById(int hallId);
    CinemaHall getCinemaHallByName(String name);
    List<CinemaHall> getAllCinemaHalls();
    void addCinemaHall(CinemaHall movieSession);
    void updateCinemaHall(CinemaHall movieSession);
    void deleteCinemaHall(int hallId);
    String getHallRows(int hallId);
}
