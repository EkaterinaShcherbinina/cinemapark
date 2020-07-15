package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.MovieSessionDAO;
import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieSessionRepository implements IMovieSessionRepository {
    @Autowired
    private MovieSessionDAO sessionDAO;

    @Autowired
    private CinemaHallRepository cinemaHallService;

    @Autowired MovieRepository movieRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<MovieSession> getAllMovieSessions() {
        return null;
    }

    @Override
    public MovieSession getMovieSessionById(int sessionId) {
        return sessionDAO.findById(sessionId).get();
    }

    @Override
    @Transactional
    public void addMovieSession(MovieSessionDTO movieSessionDTO) {
        CinemaHall hall = cinemaHallService.getCinemaHallById(movieSessionDTO.getCinemaHall().getId());
        Movie movie = movieRepository.getMovieById(movieSessionDTO.getMovie().getId());

        MovieSession movieSession = new MovieSession();
        movieSession.setDate(movieSessionDTO.getDate());
        movieSession.setTime(movieSessionDTO.getTime());
        movieSession.setCinemaHall(hall);
        movieSession.setMovie(movie);
        movieSession.setCost(movieSessionDTO.getCost());

        sessionDAO.save(movieSession);
    }

    @Override
    public void updateMovieSession(MovieSessionDTO movieSessionDTO) {
        addMovieSession(movieSessionDTO);
    }

    @Override
    public void deleteMovieSession(int sessionId) {
        sessionDAO.deleteById(sessionId);
    }

    @Override
    public List<MovieSession> getSessionsByDate(String date) {
        return sessionDAO.getSessionsByDate(java.sql.Date.valueOf(date));
    }

    @Override
    public List<MovieSession> getSessionsByDateAndMovie(String date, int movieId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MovieSession> q = cb.createQuery(MovieSession.class);
        Root<MovieSession> root = q.from(MovieSession.class);

        try {
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Predicate sessionPredicate = cb.equal(root.get("date"),
                    new SimpleDateFormat("yyyy-MM-dd").parse(date));
            Predicate moviePredicate = cb.equal(root.get("movie").get("id"), movieId);
            q.where(sessionPredicate, moviePredicate);
        } catch(ParseException ex) {
            return new LinkedList<>();
        }

        return entityManager.createQuery(q).getResultList();
    }
}
