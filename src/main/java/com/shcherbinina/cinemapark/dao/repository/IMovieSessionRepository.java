package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;

import java.util.List;

public interface IMovieSessionRepository {
    List<MovieSession> getAllMovieSessions();
    MovieSession getMovieSessionById(int sessionId);
    void addMovieSession(MovieSessionDTO movieSessionDTO);
    void updateMovieSession(MovieSessionDTO movieSessionDTO);
    void deleteMovieSession(int sessionId);
    List<MovieSession> getSessionsByDate(String date);
}
