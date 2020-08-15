package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.dto.entity.MoneyAccountDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.restControllers.AccountController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class UserAccountControllerTest {
    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private MoneyAccountDTO moneyAccountDTO;

    @Before
    public void setUp() {
        moneyAccountDTO = new MoneyAccountDTO();
        moneyAccountDTO.setAmountMoney("20.0");
    }

    @Test
    public void sendMoneyTest_unhappy() throws PayloadValidationException {
    }
}
