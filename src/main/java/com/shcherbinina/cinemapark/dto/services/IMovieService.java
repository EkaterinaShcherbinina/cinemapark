package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;

import java.sql.Blob;
import java.util.List;

public interface IMovieService {
    List<MovieThumbnailDTO> getMoviesNowInCinema();
    MovieDTO getMovieBySecondaryKey(String key);
    List<MovieThumbnailDTO> getMoviesSoonInCinema();
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(int id);
    void addNewMovie(MovieDTO movieDTO, Blob image);
    void updateMovie(MovieDTO movieDTO, Blob image);
}
