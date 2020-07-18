package com.shcherbinina.cinemapark.validatorsTest.payloadValidatorsTests;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.ReservationDTOValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ReservationDTOValidatorTest {
    @InjectMocks
    private ReservationDTOValidator reservationDTOValidator;

    private ReservationDTO reservationDTO1;
    private ReservationDTO reservationDTO2;

    @Before
    public void setUp() {
        reservationDTO1 = new ReservationDTO();
        reservationDTO1.setRowId(0);
        reservationDTO1.setPlace(1);

        reservationDTO2 = new ReservationDTO();
        reservationDTO2.setPlace(0);
        reservationDTO2.setRowId(1);
    }

    @Test
    public void validateTest_invalidRowId_unhappy() {
        Throwable thrown = assertThrows(PayloadValidationException.class, () -> {
            reservationDTOValidator.validate(reservationDTO1);
        });
        Assert.assertNotNull(thrown.getMessage());
    }

    @Test
    public void validateTest_invalidPlaceId_unhappy() {
        Throwable thrown = assertThrows(PayloadValidationException.class, () -> {
            reservationDTOValidator.validate(reservationDTO2);
        });
        Assert.assertNotNull(thrown.getMessage());
    }
}
