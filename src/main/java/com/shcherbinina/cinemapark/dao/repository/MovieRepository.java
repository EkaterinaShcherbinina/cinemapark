package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.MovieDAO;
import com.shcherbinina.cinemapark.dao.MovieSessionDAO;
import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository implements IMovieRepository {
    @Autowired
    private MovieDAO movieDAO;
    @Autowired
    private MovieSessionDAO sessionDAO;


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        movieDAO.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Movie getMovieById(long articleId) {
        return null;
    }

    @Override
    public void addMovie(Movie movie) {
        movieDAO.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        addMovie(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieDAO.deleteById(movieId);
    }

    @Override
    public List<Movie> getMoviesAfterDate(LocalDate date) {
        return movieDAO.getMoviesMoreThanDate(java.sql.Date.valueOf(LocalDate.now()));
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
        return movieDAO.findBySecondaryKey(key);
    }
}
