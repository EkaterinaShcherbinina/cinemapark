package com.shcherbinina.cinemapark.servicesTests;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.MoneyAccountDTO;
import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.businessValidation.WithdrawingMoneyValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private MovieSessionRepository sessionRepository;
    @Mock
    private WithdrawingMoneyValidator validator;

    @InjectMocks
    private UserService userService;

    private MoneyAccountDTO moneyAccountDTO1;
    private MoneyAccountDTO moneyAccountDTO2;
    private ReservationDTO reservationDTO1;
    private User user1;
    private User user2;
    private MovieSession session;
    private AdminSessionDTO sessionDTO;
    private UserDTO userDTO;

    @Before
    public void setUp() {
        moneyAccountDTO1 = new MoneyAccountDTO();
        moneyAccountDTO1.setAmountMoney("20.0");

        reservationDTO1 = new ReservationDTO();
        reservationDTO1.setSessionId(2);

        session = new MovieSession();
        session.setCost(20.0);

        user1 = new User();
        user1.setId(2);
        user1.setFirstName("Jhon");
        user1.setLastName("Pick");
        user1.setPassword("ddsscsc");
        user1.setAccount(new BigDecimal(10.0));
        user1.setEmail("fsdsfd.com");

        user2 = new User();
        user2.setId(2);
        user2.setFirstName("Jhon");
        user2.setLastName("Pick");
        user2.setPassword("ddsscsc");
        user2.setAccount(new BigDecimal(30.0));
        user2.setEmail("fsdsfd.com");

        moneyAccountDTO2 = new MoneyAccountDTO();
        moneyAccountDTO2.setAmountMoney("-20.0");

        sessionDTO = new AdminSessionDTO();
        userDTO = new UserDTO();
        sessionDTO.setCost("50.0");
        userDTO.setAccount(new BigDecimal(10.0));
    }

    @Test
    public void sendMoneyTest_validAmount_happy() throws PayloadValidationException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user1);

        userService.addMoney(moneyAccountDTO1);

        Mockito.verify(userRepository).getUserById(4);
        Mockito.verify(userRepository).updateUser(user1);
    }

    @Test
    public void getMoneyTest_happy() throws BusinessValidationException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user2);
        Mockito.when(sessionRepository.getMovieSessionById(2)).thenReturn(session);

        userService.getMoney(reservationDTO1);

        Mockito.verify(userRepository).getUserById(4);
        Mockito.verify(userRepository).updateUser(user2);
    }
}
