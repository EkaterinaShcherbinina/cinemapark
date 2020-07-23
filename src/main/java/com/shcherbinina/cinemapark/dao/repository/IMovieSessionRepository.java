package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;

import java.sql.Date;
import java.util.List;

public interface IMovieSessionRepository {
    List<MovieSession> getAllMovieSessions();
    MovieSession getMovieSessionById(int sessionId);
    void addMovieSession(MovieSession movieSession);
    void updateMovieSession(MovieSession movieSession);
    void deleteMovieSession(int sessionId);
    List<MovieSession> getSessionsByDate(String date);
    List<MovieSession> getSessionsByDateAndMovie(String date, int movieId);
}
