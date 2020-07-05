package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements  IAccountService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendMoney(AccountDTO dto) throws InvalidWithdrawalAmountException {
        if(dto.getAmountMoney() < 0) throw  new InvalidWithdrawalAmountException();

        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        user.setAccount(userAccount + dto.getAmountMoney());

        userRepository.updateUser(user);
    }

    @Override
    public void getMoney(AccountDTO dto) throws InsufficientFundsException {
        User user = userRepository.getUserById(dto.getUserId());
        double userAccount = user.getAccount();
        double difference = userAccount - dto.getAmountMoney();
        if(difference < 0) throw new InsufficientFundsException();

        user.setAccount(userAccount - dto.getAmountMoney());

        userRepository.updateUser(user);
    }
}
