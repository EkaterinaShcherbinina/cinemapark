package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;

import java.util.List;

public interface ICinemaHallService {
    void addNewCinemaHall(CinemaHallDTO movieSessionDTO);
    void updateCinemaHall(CinemaHallDTO movieSessionDTO);
    void deleteCinemaHall(int hallId);

    List<CinemaHallDTO> getAllCinemaHalls();
    CinemaHallDTO getHallById(int hallId);
}
