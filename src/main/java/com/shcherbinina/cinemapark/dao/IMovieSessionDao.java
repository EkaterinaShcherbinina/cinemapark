package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;

import java.util.List;

public interface IMovieSessionDao {
    List<MovieSession> getAllMovieSessions();
    MovieSession getMovieSessionById(int sessionId);
    void addMovieSession(MovieSession movieSession);
    void updateMovieSession(MovieSession movieSession);
    void deleteMovieSession(int sessionId);
    List<MovieSession> getSessionsByDate(String date);
    List<MovieSession> getSessionsByDateAndMovie(String date, int movieId);
}
