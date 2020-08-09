package com.shcherbinina.cinemapark.validatorsTest.payloadValidatorsTests;

import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.AccountValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class AccountValidatorTest {

    @InjectMocks
    private AccountValidator validator;

    private AccountDTO accountDTO1;
    private AccountDTO accountDTO2;

    @Before
    public void setUp() {
        accountDTO1 = new AccountDTO(1, 20.0);
        accountDTO2 = new AccountDTO(1, -10.0);
    }

   /* @Test
    public void validateTest_happy() throws PayloadValidationException {
        validator.validate(accountDTO1);
    }

    @Test
    public void validateTest_unhappy() throws PayloadValidationException {
        Throwable thrown = assertThrows(PayloadValidationException.class, () -> {
            validator.validate(accountDTO2);
        });
        Assert.assertNotNull(thrown.getMessage());
    }*/
}
