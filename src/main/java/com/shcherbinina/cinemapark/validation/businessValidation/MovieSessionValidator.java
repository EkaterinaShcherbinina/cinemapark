package com.shcherbinina.cinemapark.validation.businessValidation;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.CinemaHallDao;
import com.shcherbinina.cinemapark.dao.MovieDao;
import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionValidator implements IBusinessValidation{
    private final String validationMessage = "Invalid input data";
    @Autowired
    private CinemaHallDao cinemaHallRepository;
    @Autowired
    private MovieDao movieRepository;

    @Override
    public void validate(Object obj) throws BusinessValidationException {
        if(obj == null || obj.getClass()!= AdminSessionDTO.class) throw new BusinessValidationException(validationMessage);
        AdminSessionDTO dto = (AdminSessionDTO) obj;
        CinemaHall hall = cinemaHallRepository.getCinemaHallByName(dto.getHallName());
        Movie movie = movieRepository.getMovieByName(dto.getMovieName());

        if(hall == null || movie == null) throw new BusinessValidationException(validationMessage);
    }
}
