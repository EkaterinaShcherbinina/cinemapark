package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import org.springframework.stereotype.Component;

@Component
public class AccountValidator implements IPayloadValidation {
    private final String invalidAmountOfMoney = "Invalid amount of money";

    @Override
    public void validate(Object dto) throws PayloadValidationException {
        AccountDTO accountDTO = (AccountDTO) dto;
        if(accountDTO.getAmountMoney() < 0) throw new PayloadValidationException(invalidAmountOfMoney);
    }
}
