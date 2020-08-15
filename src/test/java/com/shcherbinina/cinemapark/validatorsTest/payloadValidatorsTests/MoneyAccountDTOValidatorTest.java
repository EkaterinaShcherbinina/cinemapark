package com.shcherbinina.cinemapark.validatorsTest.payloadValidatorsTests;

import com.shcherbinina.cinemapark.dto.entity.MoneyAccountDTO;
import com.shcherbinina.cinemapark.validation.payloadValidation.MoneyAccountDTOValidator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class MoneyAccountDTOValidatorTest {

    @InjectMocks
    private MoneyAccountDTOValidator validator;

    private MoneyAccountDTO moneyAccountDTO1;
    private MoneyAccountDTO moneyAccountDTO2;

    @Before
    public void setUp() {
        moneyAccountDTO1 = new MoneyAccountDTO();
        moneyAccountDTO1.setAmountMoney("20.0");
        moneyAccountDTO2 = new MoneyAccountDTO();
        moneyAccountDTO2.setAmountMoney("-10.0");
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
