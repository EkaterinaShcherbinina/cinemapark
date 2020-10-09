package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Role;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.MovieSessionDao;
import com.shcherbinina.cinemapark.dao.UserDao;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.security.AuthProvider;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import com.shcherbinina.cinemapark.utility.Utility;
import com.shcherbinina.cinemapark.validation.businessValidation.WithdrawingMoneyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class UserService implements IUserService {
    @Autowired
    UserDao userRepository;
    @Autowired
    MovieSessionDao sessionRepository;
    @Autowired
    private DTOConverter dtoConverter;
    @Autowired
    private AuthProvider authProvider;
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private WithdrawingMoneyValidator moneyValidator;

    @Override
    public UserDTO getById(int userId) {
        return dtoConverter.convertToUserDTO(userRepository.getUserById(userId));
    }

    @Override
    public UserDTO getByEmail(String email) {
        return dtoConverter.convertToUserDTO(userRepository.getUserByEmail(email));
    }

    public void addNewUser(UserDTO userDTO) {
        userDTO.setRoles(Collections.singleton(Role.USER));
        userRepository.addUser(dtoConverter.convertToUser(userDTO));
    }

    public void updateUser(UserDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUser(userDTO));
    }

    @Override
    public UserNameDTO getUserNameById(int userId) {
        return dtoConverter.convertToUserNameDTO(userRepository.getUserById(userId));
    }

    @Override
    public UserEmailDTO getUserEmailById(int userId) {
        return dtoConverter.convertToUserEmailDTO(userRepository.getUserById(userId));
    }

    @Override
    public MoneyAccountDTO getMoneyAccount() {
        MoneyAccountDTO accountDTO =  new MoneyAccountDTO();
        accountDTO.setAmountMoney(authenticationFacade.getCurrentUser().getAmountMoney().toString());

        return accountDTO;
    }

    @Override
    public void updateUserName(UserNameDTO userDTO) {
        authProvider.updateUserName(userDTO);
        userRepository.updateUser(dtoConverter.convertToUserForUserNameDTO(userDTO));
    }

    @Override
    public void updateUserPassword(UserPasswordDTO userDTO) {
        userRepository.updateUser(dtoConverter.convertToUserForUserPasswordDTO(userDTO));
        authProvider.updateUserPassword(userDTO);
    }

    @Override
    public void updateUserEmail(UserEmailDTO email) {
        userRepository.updateUser(dtoConverter.convertToUserForUserEmail(email));
        authProvider.updateUserEmail(email);
    }

    @Override
    public void topUpAccount(MoneyAccountDTO dto) {
        UserDTO user = authenticationFacade.getCurrentUser();
        BigDecimal userAccount = user.getAmountMoney().add(new BigDecimal(dto.getAmountMoney()));
        user.setAmountMoney(userAccount);

        userRepository.updateUser(dtoConverter.convertToUser(user));
        authProvider.updateUserAccount(userAccount);
    }

    @Override
    public void withdrawMoney(ReservationDTO dto) throws BusinessValidationException {
        moneyValidator.validate(dto);

        User user = userRepository.getUserById(Utility.getCurrentUserId());
        MovieSession session = sessionRepository.getMovieSessionById(dto.getSessionId());
        BigDecimal moneyAccount = user.getAccount().subtract(BigDecimal.valueOf(session.getCost()));
        user.setAccount(moneyAccount);
        userRepository.updateUser(user);
        authProvider.updateUserAccount(moneyAccount);
    }
}
