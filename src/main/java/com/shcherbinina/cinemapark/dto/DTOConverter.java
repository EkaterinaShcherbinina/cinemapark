package com.shcherbinina.cinemapark.dto;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;

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
    @Autowired
    private AuthenticationFacade authenticationFacade;

    public ReservationDTO convertToReservationDTO(Reservation reservation) {
        if(reservation == null) return null;

        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setPlace(reservation.getPlace());
        dto.setRowId(reservation.getRowId());
        dto.setPaid(reservation.isPaid());
        dto.setSessionId(reservation.getMovieSession().getId());

        return dto;
    }

    public Reservation convertToReservation(ReservationDTO dto) {
        if(dto == null) return null;

        User user = userRepository.getUserById(Utility.getCurrentUserId());
        MovieSession movieSession = movieSessionRepository.getMovieSessionById(dto.getSessionId());

        Reservation reservation = new Reservation();
        reservation.setPlace(dto.getPlace());
        reservation.setRowId(dto.getRowId());
        reservation.setPaid(dto.isPaid());
        reservation.assignToUser(user);
        reservation.assignToMovieSession(movieSession);

        return reservation;
    }

    public User convertToUser(UserDTO dto) {
        if(dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setAccount(dto.getAccount());
        user.setRoles(dto.getRoles());

        return user;
    }

    public UserDTO convertToUserDTO(User user) {
        if(user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setAccount(user.getAccount());
        dto.setRoles(user.getRoles());

        return dto;
    }

    public UserNameDTO convertToUserNameDTO(User user) {
        if(user == null) return null;

        UserNameDTO dto = new UserNameDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());

        return dto;
    }

    public UserEmailDTO convertToUserEmailDTO(User user) {
        if(user == null) return null;

        UserEmailDTO dto = new UserEmailDTO();
        dto.setEmail(user.getEmail());

        return dto;
    }

    public User convertToUserForUserNameDTO(UserNameDTO dto) {
        if(dto == null) return null;

        User user = userRepository.getUserById(authenticationFacade.getCurrentUserId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        return user;
    }

    public User convertToUserForUserPasswordDTO(UserPasswordDTO dto) {
        if(dto == null) return null;

        User user = userRepository.getUserById(authenticationFacade.getCurrentUserId());
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        return user;
    }

    public User convertToUserForUserEmail(UserEmailDTO email) {
        if(email == null) return null;

        User user = userRepository.getUserById(authenticationFacade.getCurrentUserId());
        user.setEmail(email.getEmail());
        return user;
    }

    public MovieDTO convertToMovieDTO(Movie movie) {
        if(movie == null) return null;

        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setActors(movie.getActors());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(Double.toString(movie.getRating()));
        dto.setGenre(movie.getGenre());
        dto.setProducer(movie.getProducer());
        dto.setProductionYear(movie.getProductionYear());
        dto.setPremiereDate(Utility.getFormattedOnlyDate(movie.getPremiereDate()));

        return dto;
    }

    public MovieThumbnailDTO convertToMovieThumbnailDTO(Movie movie) {
        if(movie == null) return null;

        MovieThumbnailDTO dto = new MovieThumbnailDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(movie.getRating());
        dto.setGenre(movie.getGenre());

        return dto;
    }

    public Movie convertToMovie(MovieDTO dto) {
        if(dto == null) return null;
        Movie movie = dto.getId() == 0 ? new Movie() : movieRepository.getMovieById(dto.getId());

        Blob image = null;
        if(!dto.getImage().isEmpty()) {
            try {
                image = new SerialBlob(dto.getImage().getBytes());
            } catch (SerialException e) {
                e.printStackTrace();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }

        movie.setName(dto.getName());
        movie.setActors(dto.getActors());
        movie.setDuration(dto.getDuration());
        movie.setDescription(dto.getDescription());
        movie.setRating(Double.parseDouble(dto.getRating()));
        movie.setGenre(dto.getGenre());
        movie.setProducer(dto.getProducer());
        movie.setProductionYear(dto.getProductionYear());
        movie.setPremiereDate(Utility.getFormattedDate(dto.getPremiereDate()));
        movie.setSecondaryKey(dto.getSecondaryKey());
        if(image != null)
            movie.setImage(image);

        return movie;
    }

    public AdminSessionDTO convertToAdminSessionDTO(MovieSession session) {
        if(session == null) return null;

        AdminSessionDTO dto = new AdminSessionDTO();
        dto.setId(session.getId());
        dto.setCost(Double.toString(session.getCost()));
        dto.setMovieDate(Utility.getFormattedOnlyDate(session.getDate()));
        dto.setWishDate(session.getDate().toString());
        dto.setTime(Utility.getFormattedTime(session.getTime()));
        dto.setHallName(session.getCinemaHall().getHallName());
        dto.setMovieName(session.getMovie().getName());

        return dto;
    }

    public MovieSessionDTO convertToMovieSessionDTO(MovieSession session) {
        if(session == null) return null;

        MovieSessionDTO dto = new MovieSessionDTO();
        dto.setId(session.getId());
        dto.setCost(Double.toString(session.getCost()));
        dto.setMovieDate(Utility.getFormattedOnlyDate(session.getDate()));
        dto.setTime(Utility.get12FormattedTime(session.getTime()));
        dto.setCinemaHall(convertToCinemaHallDto(session.getCinemaHall()));
        dto.setMovie(convertToMovieDTO(session.getMovie()));

        return dto;
    }

    public MovieSession convertToMovieSession(AdminSessionDTO dto) {
        if(dto == null) return null;

        CinemaHall hall = cinemaHallRepository.getCinemaHallByName(dto.getHallName());
        Movie movie = movieRepository.getMovieByName(dto.getMovieName());

        MovieSession session = new MovieSession();
        session.setId(dto.getId());
        session.setCost(Double.parseDouble(dto.getCost()));
        session.setTime(Utility.getTimeFromString(dto.getTime()));
        session.setDate(Utility.getFormattedDate(dto.getWishDate()));
        session.assignCinemaHall(hall);
        session.assignMovie(movie);

        return session;
    }

    public CinemaHall convertToCinemaHall(CinemaHallDTO dto) {
        if(dto == null) return null;

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(dto.getId());
        cinemaHall.setRows(Arrays.toString(dto.getPlacesAmountInRow()).replaceAll("\\[|\\]|\\s", ""));
        cinemaHall.setRowsAmount(dto.getRowsAmount());
        cinemaHall.setHallName(dto.getHallName());
        return cinemaHall;
    }

    public CinemaHallDTO convertToCinemaHallDto(CinemaHall hall) {
        if (hall == null) return null;

        CinemaHallDTO dto = new CinemaHallDTO();
        dto.setId(hall.getId());
        dto.setPlacesAmountInRow(hall.getRows().split(","));
        dto.setRowsAmount(hall.getRowsAmount());
        dto.setHallName(hall.getHallName());
        return dto;
    }
}
