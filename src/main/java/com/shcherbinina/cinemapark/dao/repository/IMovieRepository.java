package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;

import java.time.LocalDate;
import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    Movie getMovieById(long articleId);
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int movieId);
    List<Movie> getMoviesAfterDate(LocalDate date);
    List<Movie> findInCinemaByDate(String date);
    Movie getBySecondaryKey(String key);
}
