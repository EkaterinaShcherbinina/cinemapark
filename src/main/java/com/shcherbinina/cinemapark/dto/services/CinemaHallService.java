package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallService implements ICinemaHallService {
    @Autowired
    private CinemaHallRepository cinemaHallRepository;


    @Override
    public void addNewCinemaHall(CinemaHallDTO cinemaHallDTO) {
        cinemaHallRepository.addCinemaHall(DTOConverter.convertToCinemaHall(cinemaHallDTO));
    }

    @Override
    public void updateCinemaHall(CinemaHallDTO cinemaHallDTO) {
        cinemaHallRepository.updateCinemaHall(DTOConverter.convertToCinemaHall(cinemaHallDTO));
    }

    @Override
    public void deleteCinemaHall(int hallId) {
        cinemaHallRepository.deleteCinemaHall(hallId);
    }
}
