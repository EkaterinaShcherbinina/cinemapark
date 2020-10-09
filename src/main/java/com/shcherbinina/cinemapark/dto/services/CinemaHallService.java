package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.CinemaHallDao;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaHallService implements ICinemaHallService {
    @Autowired
    private CinemaHallDao cinemaHallRepository;
    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public void addNewCinemaHall(CinemaHallDTO cinemaHallDTO) {
        cinemaHallRepository.addCinemaHall(dtoConverter.convertToCinemaHall(cinemaHallDTO));
    }

    @Override
    public void updateCinemaHall(CinemaHallDTO cinemaHallDTO) {
        cinemaHallRepository.updateCinemaHall(dtoConverter.convertToCinemaHall(cinemaHallDTO));
    }

    @Override
    public void deleteCinemaHall(int hallId) {
        cinemaHallRepository.deleteCinemaHall(hallId);
    }

    @Override
    public List<CinemaHallDTO> getAllCinemaHalls() {
        List<CinemaHall> dtos = cinemaHallRepository.getAllCinemaHalls();
        return dtos.stream().map(hall -> dtoConverter.convertToCinemaHallDto(hall)).collect(Collectors.toList());
    }

    @Override
    public CinemaHallDTO getHallById(int hallId) {
        return dtoConverter.convertToCinemaHallDto(cinemaHallRepository.getCinemaHallById(hallId));
    }
}
