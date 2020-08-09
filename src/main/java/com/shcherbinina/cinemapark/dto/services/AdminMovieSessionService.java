package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.validation.businessValidation.MovieSessionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMovieSessionService implements IAdminMovieSessionService {
    @Autowired
    MovieSessionRepository sessionRepository;
    @Autowired
    private DTOConverter dtoConverter;
    @Autowired
    private MovieSessionValidator movieSessionValidator;

    @Override
    public void updateMovieSession(AdminSessionDTO sessionDTO) {
        sessionRepository.updateMovieSession(dtoConverter.convertToMovieSession(sessionDTO));
    }

    @Override
    public void addMovieSession(AdminSessionDTO sessionDTO) throws BusinessValidationException {
        movieSessionValidator.validate(sessionDTO);
        sessionRepository.addMovieSession(dtoConverter.convertToMovieSession(sessionDTO));
    }

    @Override
    public AdminSessionDTO getById(int sessionId) {
        return dtoConverter.convertToAdminSessionDTO(sessionRepository.getMovieSessionById(sessionId));
    }

    @Override
    public List<AdminSessionDTO> getAllMovieSessionsByDate(String date) {
        List<MovieSession> sessions = sessionRepository.getSessionsByDate(date);
        return sessions.stream().map(session -> dtoConverter.convertToAdminSessionDTO(session))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdminSessionDTO> getSessionsByDateAndMovieName(String date, int movieId) {
        List<MovieSession> sessions = sessionRepository.getSessionsByDateAndMovie(date, movieId);
        return sessions.stream().map(session -> dtoConverter.convertToAdminSessionDTO(session))
                .collect(Collectors.toList());
    }
}
