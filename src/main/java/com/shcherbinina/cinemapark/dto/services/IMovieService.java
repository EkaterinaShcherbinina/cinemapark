package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getMoviesNowInCinema();
    MovieDTO getMovieByKey(String key);
    List<MovieDTO> getMoviesSoonInCinema();
    void addNewMovie(MovieDTO movieDTO);
    void updateMovie(MovieDTO movieDTO);
    void deleteMovie(int movieId);
}
