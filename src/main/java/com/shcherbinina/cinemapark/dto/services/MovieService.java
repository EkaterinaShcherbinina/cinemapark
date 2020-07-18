package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;
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
    public void addNewMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie.setActors(movieDTO.getActors());
        movie.setDescription(movieDTO. getDescription());
        movie.setDuration(movieDTO.getDuration());
        movie.setGenre(movieDTO.getGenre());
        movie.setName(movieDTO.getName());
        movie.setPremiereDate(movieDTO.getPremiereDate());
        movie.setProducer(movieDTO.getProducer());
        movie.setProductionYear(movieDTO.getProductionYear());
        movie.setRating(movieDTO.getRating());

        movieRepository.addMovie(movie);
    }

    @Override
    public void updateMovie(MovieDTO movieDTO) {
        addNewMovie(movieDTO);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteMovie(movieId);
    }
}
