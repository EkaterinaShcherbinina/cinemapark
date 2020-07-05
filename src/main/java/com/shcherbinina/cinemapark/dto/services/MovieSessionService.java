package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieSessionService implements IMovieSessionService {
    @Autowired
    MovieSessionRepository sessionRepository;
    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public List<MovieSessionDTO> getAllMovieSessionsByDate(String date) {
        List<MovieSession> sessions = sessionRepository.getSessionsByDate(date);
        return sessions.stream().map(session -> dtoConverter.convertToMovieSessionDTO(session))
                .collect(Collectors.toList());
    }
}
