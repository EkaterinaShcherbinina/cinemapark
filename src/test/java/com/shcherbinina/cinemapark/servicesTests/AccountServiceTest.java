package com.shcherbinina.cinemapark.servicesTests;

import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountService accountService;

    private AccountDTO accountDTO1;
    private AccountDTO accountDTO2;
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        accountDTO1 = new AccountDTO(4, 20.0);

        user1 = new User();
        user1.setId(2);
        user1.setFirstName("Jhon");
        user1.setLastName("Pick");
        user1.setPassword("ddsscsc");
        user1.setAccount(10.0);
        user1.setEmail("fsdsfd.com");

        user2 = new User();
        user2.setId(2);
        user2.setFirstName("Jhon");
        user2.setLastName("Pick");
        user2.setPassword("ddsscsc");
        user2.setAccount(30.0);
        user2.setEmail("fsdsfd.com");

        accountDTO2 = new AccountDTO(4, -20.0);
    }

    @Test
    public void sendMoneyTest_invalidAmount_happy() throws InvalidWithdrawalAmountException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user1);

        accountService.sendMoney(accountDTO1);

        Mockito.verify(userRepository).getUserById(4);
        Mockito.verify(userRepository).updateUser(user1);
    }

    @Test
    public void sendMoneyTest_unhappy() throws InvalidWithdrawalAmountException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user1);

        Throwable thrown = assertThrows(InvalidWithdrawalAmountException.class, () -> {
            accountService.sendMoney(accountDTO2);
        });
        Assert.assertNotNull(thrown.getMessage());
    }

    @Test
    public void getMoneyTest_happy() throws InsufficientFundsException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user2);

        accountService.getMoney(accountDTO1);

        Mockito.verify(userRepository).getUserById(4);
        Mockito.verify(userRepository).updateUser(user2);
    }

    @Test
    public void getMoneyTest_unhappy() throws InsufficientFundsException {
        Mockito.when(userRepository.getUserById(4)).thenReturn(user1);

        Throwable thrown = assertThrows(InsufficientFundsException.class, () -> {
            accountService.getMoney(accountDTO1);
        });
        Assert.assertNotNull(thrown.getMessage());
    }
}
