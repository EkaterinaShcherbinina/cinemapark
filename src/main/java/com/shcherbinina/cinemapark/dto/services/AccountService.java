package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.utility.Utility;
import com.shcherbinina.cinemapark.validation.businessValidation.WithdrawingMoneyValidator;
import com.shcherbinina.cinemapark.validation.payloadValidation.AccountValidator;
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
    private WithdrawingMoneyValidator validator;
    @Autowired
    private AccountValidator accountValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieSessionRepository sessionRepository;
    @Autowired
    private ReservationService reservationService;

    @Override
    public void sendMoney(AccountDTO dto) throws PayloadValidationException {
        //accountValidator.validate(dto);

        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        user.setAccount(userAccount + dto.getAmountMoney());

        userRepository.updateUser(user);
    }

    @Override
    public void getMoney(ReservationDTO dto) throws BusinessValidationException {
        validator.validate(dto);

        User user = userRepository.getUserById(Utility.getCurrentUserId());
        MovieSession session = sessionRepository.getMovieSessionById(dto.getSessionId());
        user.setAccount(user.getAccount() - session.getCost());
        userRepository.updateUser(user);
    }

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
