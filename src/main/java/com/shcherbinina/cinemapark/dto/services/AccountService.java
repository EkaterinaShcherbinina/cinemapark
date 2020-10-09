package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.MovieSessionDao;
import com.shcherbinina.cinemapark.dao.UserDao;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements  IAccountService{
    @Autowired
    private DTOConverter dtoConverter;
    @Autowired
    private UserDao userRepository;
    @Autowired
    private MovieSessionDao sessionRepository;
    @Autowired
    private ReservationService reservationService;

    @Override
    @Transactional
    public UserHistoryDTO getUserHistory(int userId) {
        if(userId == 0) return null;

        List<MovieThumbnailDTO> movies = getHistoryMovies(userId);
        int purchasedTickets = getPurchasedTickets(userId);
        BigDecimal total = getTotalTicketsPrice(userId);

        UserHistoryDTO history = new UserHistoryDTO();
        history.setMovies(movies);
        history.setPurchasedTickets(purchasedTickets);
        history.setTotalSpend(total);

        return history;
    }

    private List<MovieThumbnailDTO> getHistoryMovies(int userId) {
        User user = userRepository.getUserById(userId);
        return user.getReservations().stream()
                .map(res -> res.getMovieSession().getMovie())
                .distinct()
                .map(m -> dtoConverter.convertToMovieThumbnailDTO(m))
                .collect(Collectors.toList());
    }

    private int getPurchasedTickets(int userId) {
        User user = userRepository.getUserById(userId);
        return user.getReservations().size();
    }

    private BigDecimal getTotalTicketsPrice(int userId) {
        User user = userRepository.getUserById(userId);
        double sum = user.getReservations().stream().map(Reservation::getMovieSession)
                .mapToDouble(MovieSession::getCost)
                .sum();
        return BigDecimal.valueOf(sum);
    }
}
