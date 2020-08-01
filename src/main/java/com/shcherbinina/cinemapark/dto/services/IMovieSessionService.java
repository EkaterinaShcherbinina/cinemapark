package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;

import java.util.List;

public interface IMovieSessionService {
    MovieSessionDTO getById(int sessionId);
    List<MovieSessionDTO> getAllMovieSessionsByDate(String date);
    List<MovieSessionDTO> getSessionsByDateAndMovieName(String date, int movieId);
}
