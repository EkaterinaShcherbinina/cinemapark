package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;

import java.util.List;

public interface IMovieSessionService {
    List<MovieSessionDTO> getAllMovieSessionsByDate(String date);
    List<MovieSessionDTO> getSessionsByDateAndMovieName(String date, int movieId);
}
