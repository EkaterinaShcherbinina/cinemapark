package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieSessionService implements IMovieSessionService {
    @Autowired
    MovieSessionRepository sessionRepository;
    @Autowired
    private DTOConverter dtoConverter;

    private final String today = "today";

    @Override
    public MovieSessionDTO getById(int sessionId) {
        return dtoConverter.convertToMovieSessionDTO(sessionRepository.getMovieSessionById(sessionId));
    }

    @Override
    public List<MovieSessionDTO> getAllMovieSessionsByDate(String date) {
        if(today.equals(date)) date = LocalDate.now().toString();
        List<MovieSession> sessions = sessionRepository.getSessionsByDate(date);
        return sessions.stream().map(session -> dtoConverter.convertToMovieSessionDTO(session))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieSessionDTO> getSessionsByDateAndMovieName(String date, int movieId) {
        if(today.equals(date)) date = LocalDate.now().toString();
        List<MovieSession> sessions = sessionRepository.getSessionsByDateAndMovie(date, movieId);
        return sessions.stream().map(session -> dtoConverter.convertToMovieSessionDTO(session))
                .collect(Collectors.toList());
    }
}
