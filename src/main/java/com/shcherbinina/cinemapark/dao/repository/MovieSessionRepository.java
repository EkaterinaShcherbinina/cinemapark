package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.MovieSessionDAO;
import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MovieSessionRepository implements IMovieSessionRepository {
    @Autowired
    private MovieSessionDAO sessionDAO;

    @Autowired
    private CinemaHallRepository cinemaHallService;

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
        CinemaHall hall = cinemaHallService.getCinemaHallById(movieSessionDTO.getCinemaHallId());

        MovieSession movieSession = new MovieSession();
        movieSession.setMovieId(movieSessionDTO.getMovieId());
        movieSession.setDate(movieSessionDTO.getDate());
        movieSession.setTime(movieSessionDTO.getTime());
        movieSession.setCinemaHall(hall);
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


}
