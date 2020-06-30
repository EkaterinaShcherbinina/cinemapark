package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;

public interface ICinemaHallService {
    void addNewCinemaHall(CinemaHallDTO movieSessionDTO);
    void updateCinemaHall(CinemaHallDTO movieSessionDTO);
    void deleteCinemaHall(int hallId);
}
