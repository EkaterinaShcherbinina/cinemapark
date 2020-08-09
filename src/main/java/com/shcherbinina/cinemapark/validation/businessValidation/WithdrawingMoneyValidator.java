package com.shcherbinina.cinemapark.validation.businessValidation;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.utility.Utility;
import com.sun.xml.bind.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawingMoneyValidator implements IBusinessValidation {
    private String message = "Insufficient funds in the account";

    @Autowired
    private AdminMovieSessionService sessionService;
    @Autowired
    private UserService userService;

    @Override
    public void validate(Object dto) throws BusinessValidationException {
        ReservationDTO reservationDTO = (ReservationDTO) dto;
        AdminSessionDTO session = sessionService.getById(reservationDTO.getSessionId());
        UserDTO user = userService.getById(Utility.getCurrentUserId());
        if(user.getAccount() - Double.parseDouble(session.getCost()) < 0) throw new BusinessValidationException(message);
    }
}
