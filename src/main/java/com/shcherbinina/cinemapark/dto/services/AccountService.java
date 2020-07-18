package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.businessValidation.WithdrawingMoneyValidator;
import com.shcherbinina.cinemapark.validation.payloadValidation.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements  IAccountService{
    @Autowired
    private WithdrawingMoneyValidator validator;
    @Autowired
    private AccountValidator accountValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieSessionRepository sessionRepository;

    @Override
    public void sendMoney(AccountDTO dto) throws PayloadValidationException {
        accountValidator.validate(dto);

        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        user.setAccount(userAccount + dto.getAmountMoney());

        userRepository.updateUser(user);
    }

    @Override
    public void getMoney(ReservationDTO dto) throws BusinessValidationException {
        validator.validate(dto);

        User user = userRepository.getUserById(dto.getUserId());
        MovieSession session = sessionRepository.getMovieSessionById(dto.getSessionId());
        user.setAccount(user.getAccount() - session.getCost());
        userRepository.updateUser(user);
    }
}
