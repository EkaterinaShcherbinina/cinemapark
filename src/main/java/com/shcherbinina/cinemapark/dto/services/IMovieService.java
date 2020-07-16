package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;

import java.util.List;

public interface IMovieService {
    List<MovieThumbnailDTO> getMoviesNowInCinema();
    MovieDTO getMovieBySecondaryKey(String key);
    List<MovieThumbnailDTO> getMoviesSoonInCinema();
    void addNewMovie(MovieDTO movieDTO);
    void updateMovie(MovieDTO movieDTO);
    void deleteMovie(int movieId);
}
