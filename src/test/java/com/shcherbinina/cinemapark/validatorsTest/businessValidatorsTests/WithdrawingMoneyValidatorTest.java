package com.shcherbinina.cinemapark.validatorsTest.businessValidatorsTests;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.validation.businessValidation.WithdrawingMoneyValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawingMoneyValidatorTest {
    @Mock
    private AdminMovieSessionService sessionService;
    @Mock
    private UserService userService;

    @InjectMocks
    private WithdrawingMoneyValidator validator;

    private AdminSessionDTO sessionDTO1;
    private UserDTO userDTO1;
    private UserDTO userDTO2;
    private ReservationDTO reservationDTO;

    @Before
    public void setUp() {
        sessionDTO1 = new AdminSessionDTO();
        sessionDTO1.setId(1);
        sessionDTO1.setCost("20.0");

        userDTO1 = new UserDTO();
        userDTO1.setId(1);
        userDTO1.setAccount(new BigDecimal(30.0));

        userDTO2 = new UserDTO();
        userDTO2.setId(1);
        userDTO2.setAccount(new BigDecimal(10.0));

        reservationDTO = new ReservationDTO();
        reservationDTO.setId(1);
        reservationDTO.setSessionId(1);
    }

    @Test
    public void validateTest_happy() throws BusinessValidationException {
        Mockito.when(sessionService.getById(1)).thenReturn(sessionDTO1);
        Mockito.when(userService.getById(1)).thenReturn(userDTO1);
        validator.validate(reservationDTO);
        Mockito.verify(sessionService).getById(Mockito.eq(1));
        Mockito.verify(userService).getById(Mockito.eq(1));
    }

    @Test
    public void validateTest_unhappy() {
        Mockito.when(sessionService.getById(1)).thenReturn(sessionDTO1);
        Mockito.when(userService.getById(1)).thenReturn(userDTO2);

        Throwable thrown = assertThrows(BusinessValidationException.class, () -> {
            validator.validate(reservationDTO);
        });
        Assert.assertNotNull(thrown.getMessage());
    }
}
