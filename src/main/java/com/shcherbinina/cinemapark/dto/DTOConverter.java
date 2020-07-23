package com.shcherbinina.cinemapark.dto;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieSessionRepository movieSessionRepository;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ReservationDTO convertToReservationDTO(Reservation reservation) {
        if(reservation == null) return null;

        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setPlace(reservation.getPlace());
        dto.setRowId(reservation.getRowId());
        dto.setIsPaid(reservation.getIsPaid());
        dto.setSessionId(reservation.getMovieSession().getId());
        dto.setUserId(reservation.getUser().getId());

        return dto;
    }

    public Reservation convertToReservation(ReservationDTO dto) {
        if(dto == null) return null;

        User user = userRepository.getUserById(dto.getUserId());
        MovieSession movieSession = movieSessionRepository.getMovieSessionById(dto.getSessionId());

        Reservation reservation = new Reservation();
        reservation.setPlace(dto.getPlace());
        reservation.setRowId(dto.getRowId());
        reservation.setIsPaid(dto.getIsPaid());
        reservation.assignToUser(user);
        reservation.assignToMovieSession(movieSession);

        return reservation;
    }

    public User convertToUser(UserDTO dto) {
        if(dto == null) return null;

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setAccount(dto.getAccount());

        return user;
    }

    public UserDTO convertToUserDTO(User user) {
        if(user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setAccount(user.getAccount());
        dto.setRoles(user.getRoles());

        return dto;
    }

    public MovieDTO convertToMovieDTO(Movie movie) {
        if(movie == null) return null;

        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setImageId(movie.getImageId());
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

    public MovieThumbnailDTO convertToMovieThumbnailDTO(Movie movie) {
        if(movie == null) return null;

        MovieThumbnailDTO dto = new MovieThumbnailDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setImageId(movie.getImageId());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(movie.getRating());
        dto.setGenre(movie.getGenre());

        return dto;
    }

    public Movie convertToMovie(MovieDTO dto) {
        if(dto == null) return null;

        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setSecondaryKey(dto.getSecondaryKey());
        movie.setName(dto.getName());
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

    public MovieSession convertToMovieSession(MovieSessionDTO dto) {
        if(dto == null) return null;

        CinemaHall hall = cinemaHallRepository.getCinemaHallById(dto.getCinemaHall().getId());
        Movie movie = movieRepository.getMovieById(dto.getMovie().getId());

        MovieSession session = new MovieSession();
        session.setId(dto.getId());
        session.setCost(dto.getCost());
        session.setTime(dto.getTime());
        session.setDate(dto.getDate());
        session.assignCinemaHall(hall);
        session.assignMovie(movie);

        return session;
    }

    public MovieSessionDTO convertToMovieSessionDTO(MovieSession session) {
        if(session == null) return null;

        MovieSessionDTO dto = new MovieSessionDTO();
        dto.setId(session.getId());
        dto.setCost(session.getCost());
        dto.setDate(session.getDate());
        dto.setTime(session.getTime());
        dto.setCinemaHall(session.getCinemaHall());
        dto.setMovie(convertToMovieDTO(session.getMovie()));

        return dto;
    }

    public CinemaHall convertToCinemaHall(CinemaHallDTO dto) {
        if(dto == null) return null;

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setRows(dto.getRows());
        cinemaHall.setRowsAmount(dto.getRowsAmount());
        cinemaHall.setHallName(dto.getHallName());
        return cinemaHall;
    }

    public CinemaHallDTO convertToCinemaHallDto(CinemaHall hall) {
        if(hall == null) return null;

        CinemaHallDTO dto = new CinemaHallDTO();
        dto.setRows(hall.getRows());
        dto.setRowsAmount(hall.getRowsAmount());
        dto.setHallName(hall.getHallName());
        return dto;
    }

    public MovieImageDTO convertToMovieImageDTO(MovieImage image) {
        MovieImageDTO dto = new MovieImageDTO();
        dto.setId(image.getId());
        dto.setImage(image.getImage());

        return dto;
    }
}
