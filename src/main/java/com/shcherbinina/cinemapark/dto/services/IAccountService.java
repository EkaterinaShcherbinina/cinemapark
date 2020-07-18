package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;

public interface IAccountService {
    void sendMoney(AccountDTO dto) throws PayloadValidationException;
    void getMoney(ReservationDTO dto) throws BusinessValidationException;
}
