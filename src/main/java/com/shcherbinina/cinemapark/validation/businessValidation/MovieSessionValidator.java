package com.shcherbinina.cinemapark.validation.businessValidation;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionValidator implements IBusinessValidation{
    private final String validationMessage = "Invalid input data";
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void validate(Object obj) throws BusinessValidationException {
        if(obj == null || obj.getClass()!= AdminSessionDTO.class) throw new BusinessValidationException(validationMessage);
        AdminSessionDTO dto = (AdminSessionDTO) obj;
        CinemaHall hall = cinemaHallRepository.getCinemaHallByName(dto.getHallName());
        Movie movie = movieRepository.getMovieByName(dto.getMovieName());

        if(hall == null || movie == null) throw new BusinessValidationException(validationMessage);
    }
}
