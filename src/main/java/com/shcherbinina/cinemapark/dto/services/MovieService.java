package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.MovieDao;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieDao movieRepository;
    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public List<MovieThumbnailDTO> getMoviesNowInCinema() {
        List<Movie> movies = movieRepository.findInCinemaByDate(LocalDate.now().toString());
        return movies.stream().map(res -> dtoConverter.convertToMovieThumbnailDTO(res)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieBySecondaryKey(String key) {
        Movie movie = movieRepository.getBySecondaryKey(key);
        return dtoConverter.convertToMovieDTO(movie);
    }

    @Override
    public List<MovieThumbnailDTO> getMoviesSoonInCinema() {
        List<Movie> movies = movieRepository.getMoviesAfterDate(LocalDate.now());
        return movies.stream().map(movie -> dtoConverter.convertToMovieThumbnailDTO(movie))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.getAllMovies();
        return movies.stream().map(movie -> dtoConverter.convertToMovieDTO(movie))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(int id) {
        return dtoConverter.convertToMovieDTO(movieRepository.getMovieById(id));
    }

    @Override
    public MovieDTO getMovieByName(String movieName) {
        return dtoConverter.convertToMovieDTO(movieRepository.getMovieByName(movieName));
    }

    @Override
    public Blob getImageByMovieId(int id) {
        return movieRepository.getImageByMovieId(id);
    }

    @Override
    public void addNewMovie(MovieDTO movieDTO) {
        movieDTO.setSecondaryKey(Utility.createStringWithDash(movieDTO.getName()));
        movieRepository.addMovie(dtoConverter.convertToMovie(movieDTO));
    }

    @Override
    public void updateMovie(MovieDTO movieDTO) {
        movieRepository.updateMovie(dtoConverter.convertToMovie(movieDTO));
    }
}
