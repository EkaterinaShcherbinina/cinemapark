package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;

public interface IAccountService {
    void sendMoney(AccountDTO dto) throws InvalidWithdrawalAmountException;
    void getMoney(ReservationDTO dto) throws InsufficientFundsException;
}
