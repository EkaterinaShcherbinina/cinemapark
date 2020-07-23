package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.MovieSessionDAO;
import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

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
    public void addMovieSession(MovieSession movieSession) {
        sessionDAO.save(movieSession);
    }

    @Override
    public void updateMovieSession(MovieSession movieSession) {
        addMovieSession(movieSession);
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
            Predicate sessionPredicate = cb.equal(root.get("date"),
                    new SimpleDateFormat(Constants.dateFormat).parse(date));
            Predicate moviePredicate = cb.equal(root.get("movie").get("id"), movieId);
            q.where(sessionPredicate, moviePredicate);
        } catch(ParseException ex) {
            return new LinkedList<>();
        }

        return entityManager.createQuery(q).getResultList();
    }
}
