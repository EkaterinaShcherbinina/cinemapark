package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieDao implements IMovieDao {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieSessionRepository sessionDAO;


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        movieRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMoviesAfterDate(LocalDate date) {
        return movieRepository.getMoviesMoreThanDate(java.sql.Date.valueOf(LocalDate.now()));
    }

    @Override
    public List<Movie> findInCinemaByDate(String date) {
        List<Movie> all = getAllMovies();
        List<Integer> allSessionsNow = sessionDAO.getNonRepeatingMovieIdForSessionsByDate(java.sql.Date.valueOf(date));
        List<Movie> res = all.stream().filter(movie -> {
            for (Integer val:allSessionsNow) {
                if(movie.getId() == val) return true;
            }
            return false;
        }).collect(Collectors.toList());
        return res;
    }

    @Override
    public Movie getBySecondaryKey(String key) {
        return movieRepository.findBySecondaryKey(key);
    }

    @Override
    public Blob getImageByMovieId(int id) {
        Movie movie = movieRepository.findById(id);
        return movie.getImage();
    }
}
