package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements  IAccountService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieSessionRepository sessionRepository;

    @Override
    public void sendMoney(AccountDTO dto) throws InvalidWithdrawalAmountException {
        if(dto.getAmountMoney() < 0) throw  new InvalidWithdrawalAmountException();

        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        user.setAccount(userAccount + dto.getAmountMoney());

        userRepository.updateUser(user);
    }

    @Override
    public void getMoney(ReservationDTO dto) throws InsufficientFundsException {
        MovieSession session = sessionRepository.getMovieSessionById(dto.getSessionId());
        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        double difference = userAccount - session.getCost();
        if(difference < 0) throw new InsufficientFundsException();

        user.setAccount(difference);
        userRepository.updateUser(user);
    }
}
