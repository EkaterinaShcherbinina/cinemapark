package com.shcherbinina.cinemapark.dto;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.dto.services.MovieImageService;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
    private MovieImageService imageService;

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

    public AccountEditDTO convertToUserAccountDTO(User user) {
        if(user == null) return null;

        AccountEditDTO dto = new AccountEditDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        return dto;
    }

    public User convertToUserAccount(AccountEditDTO dto) {
        if(dto == null) return null;

        User user = userRepository.getUserById(dto.getId());
        if(dto.getFirstName() != null
            && !dto.getFirstName().isEmpty())
            user.setFirstName(dto.getFirstName());
        if(dto.getLastName() != null
            && !dto.getLastName().isEmpty())
            user.setLastName(dto.getLastName());
        if(dto.getEmail() != null
            && !dto.getEmail().isEmpty())
            user.setEmail(dto.getEmail());
        if(dto.getNewPassword() != null
            && !dto.getNewPassword().isEmpty())
            user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        return user;
    }

    public MovieDTO convertToMovieDTO(Movie movie) {
        if(movie == null) return null;

        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setImageId(movie.getImage().getId());
        dto.setActors(movie.getActors());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(movie.getRating());
        dto.setGenre(movie.getGenre());
        dto.setProducer(movie.getProducer());
        dto.setProductionYear(movie.getProductionYear());
        dto.setPremiereDate(movie.getPremiereDate().toString());

        return dto;
    }

    public MovieThumbnailDTO convertToMovieThumbnailDTO(Movie movie) {
        if(movie == null) return null;

        MovieThumbnailDTO dto = new MovieThumbnailDTO();
        dto.setId(movie.getId());
        dto.setSecondaryKey(movie.getSecondaryKey());
        dto.setName(movie.getName());
        dto.setImageId(movie.getImage().getId());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        dto.setRating(movie.getRating());
        dto.setGenre(movie.getGenre());

        return dto;
    }

    public Movie convertToMovie(MovieDTO dto) {
        if(dto == null) return null;

        MovieImageDTO image = null;
        if(dto.getImageId() != 0)
            image = imageService.getMovieImageDTOByImageId(dto.getImageId());

        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setName(dto.getName());
        movie.setActors(dto.getActors());
        movie.setDuration(dto.getDuration());
        movie.setDescription(dto.getDescription());
        movie.setRating(dto.getRating());
        movie.setGenre(dto.getGenre());
        movie.setProducer(dto.getProducer());
        movie.setProductionYear(dto.getProductionYear());
        movie.setPremiereDate(Utility.getFormattedDate(dto.getPremiereDate()));
        movie.assignToImage(convertToMovieImage(image));

        if(dto.getSecondaryKey() != null)
            movie.setSecondaryKey(dto.getSecondaryKey());
        else movie.setSecondaryKey(createSecondaryKey(dto.getName()));

        return movie;
    }

    public AdminSessionDTO convertToAdminSessionDTO(MovieSession session) {
        if(session == null) return null;

        AdminSessionDTO dto = new AdminSessionDTO();
        dto.setId(session.getId());
        dto.setCost(session.getCost());
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
        dto.setCost(session.getCost());
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
        session.setCost(dto.getCost());
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
        if(hall == null) return null;

        CinemaHallDTO dto = new CinemaHallDTO();
        dto.setId(hall.getId());
        dto.setPlacesAmountInRow(Arrays.stream(hall.getRows().split(",")).mapToInt(Integer::parseInt).toArray());
        dto.setRowsAmount(hall.getRowsAmount());
        dto.setHallName(hall.getHallName());
        return dto;
    }

    public MovieImageDTO convertToMovieImageDTO(MovieImage image) {
        if(image == null) return  null;

        MovieImageDTO dto = new MovieImageDTO();
        dto.setId(image.getId());
        dto.setImage(image.getImage());

        return dto;
    }

    public MovieImage convertToMovieImage(MovieImageDTO dto) {
        if(dto == null) return null;

        MovieImage image = new MovieImage();
        image.setId(dto.getId());
        image.setImage(dto.getImage());

        return image;
    }

    private String createSecondaryKey(String name) {
        return name.replaceAll("\\s+", "-").toLowerCase();
    }
}
