package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    Movie getMovieById(int id);
    Movie getMovieByName(String name);
    void addMovie(Movie movie, Blob image);
    void updateMovie(Movie movie);
    List<Movie> getMoviesAfterDate(LocalDate date);
    List<Movie> findInCinemaByDate(String date);
    Movie getBySecondaryKey(String key);
}
