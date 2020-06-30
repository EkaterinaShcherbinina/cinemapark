package com.shcherbinina.cinemapark.dto;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

public class DTOConverter {
    @Autowired
    private static UserRepository userRepository;
    @Autowired
    private static MovieSessionRepository movieSessionRepository;
    @Autowired
    private static CinemaHallRepository cinemaHallRepository;

    public static ReservationDTO convertToReservationDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setPlace(reservation.getPlace());
        dto.setRowId(reservation.getRowId());
        dto.setSessionId(reservation.getMovieSession().getId());
        dto.setUserId(reservation.getUser().getId());

        return dto;
    }

    public static Reservation convertToReservation(ReservationDTO dto) {
        User user = userRepository.getUserById(dto.getUserId());
        MovieSession movieSession = movieSessionRepository.getMovieSessionById(dto.getSessionId());

        Reservation reservation = new Reservation();
        reservation.setPlace(dto.getPlace());
        reservation.setRowId(dto.getRowId());
        reservation.assignToUser(user);
        reservation.assignToMovieSession(movieSession);

        return reservation;
    }

    public static User convertToUser(UserDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setAccount(dto.getAccount());

        return user;
    }

    public static UserDTO convertToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setAccount(user.getAccount());

        return dto;
    }

    public static MovieDTO convertToMovieDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setName(movie.getName());
        dto.setImageUrl(movie.getImageUrl());
        dto.setActors(movie.getActors());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(movie.getRating());
        dto.setGenre(movie.getGenre());
        dto.setProducer(movie.getProducer());
        dto.setProductionYear(movie.getProductionYear());
        dto.setPremiereDate(movie.getPremiereDate());

        return dto;
    }

    public static Movie convertToMovie(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setName(dto.getName());
        movie.setImageUrl(dto.getImageUrl());
        movie.setActors(dto.getActors());
        movie.setDuration(dto.getDuration());
        movie.setDescription(dto.getDescription());
        movie.setRating(dto.getRating());
        movie.setGenre(dto.getGenre());
        movie.setProducer(dto.getProducer());
        movie.setProductionYear(dto.getProductionYear());
        movie.setPremiereDate(dto.getPremiereDate());

        return movie;
    }

    public static MovieSession convertToMovieSession(MovieSessionDTO dto) {
        CinemaHall hall = cinemaHallRepository.getCinemaHallById(dto.getCinemaHallId());

        MovieSession session = new MovieSession();
        session.setId(dto.getId());
        session.setMovieId(dto.getMovieId());
        session.setCost(dto.getCost());
        session.setTime(dto.getTime());
        session.setDate(dto.getDate());
        session.assignCinemaHall(hall);

        return session;
    }

    public static MovieSessionDTO convertToMovieSessionDTO(MovieSession session) {
        MovieSessionDTO dto = new MovieSessionDTO();
        dto.setId(session.getId());
        dto.setMovieId(session.getMovieId());
        dto.setCost(session.getCost());
        dto.setDate(session.getDate());
        dto.setTime(session.getTime());
        dto.setCinemaHallId(session.getCinemaHall().getId());

        return dto;
    }

    public static CinemaHall convertToCinemaHall(CinemaHallDTO dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setRows(dto.getRows());
        cinemaHall.setRowsAmount(dto.getRowsAmount());
        return cinemaHall;
    }

    public static CinemaHallDTO convertToCinemaHallDto(CinemaHall hall) {
        CinemaHallDTO dto = new CinemaHallDTO();
        dto.setRows(hall.getRows());
        dto.setRowsAmount(hall.getRowsAmount());
        return dto;
    }
}
