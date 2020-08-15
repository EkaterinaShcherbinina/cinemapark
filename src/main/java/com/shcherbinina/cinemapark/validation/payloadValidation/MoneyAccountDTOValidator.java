package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.MoneyAccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

import static com.google.common.base.Strings.isNullOrEmpty;

@Component
public class MoneyAccountDTOValidator implements Validator {
    private final String invalidAmountOfMoney = "Invalid amount of money";
    private final String negativeAmountOfMoney = "Amount of money must be more than zero";

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object obj, Errors errors) {
        MoneyAccountDTO dto = (MoneyAccountDTO) obj;

        try {
            String moneyAmount = dto.getAmountMoney();
            if(!isNullOrEmpty(moneyAmount)) {
                BigDecimal money = new BigDecimal(moneyAmount);
                if(money.signum() <= 0) errors.rejectValue("amountMoney", "", negativeAmountOfMoney);
            }
        } catch(NumberFormatException ex) {
            errors.rejectValue("amountMoney", "", invalidAmountOfMoney);
        }
    }
}
