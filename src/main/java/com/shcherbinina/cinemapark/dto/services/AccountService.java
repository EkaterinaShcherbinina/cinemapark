package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private UserRepository userRepository;

    public void sendMoney(int userId, double amount) {
        User user = userRepository.getUserById(userId);
        double userAccount = user.getAccount();
        user.setAccount(userAccount - amount);

        userRepository.updateUser(user);
    }

    public void getMoney(double amount) {

    }
}
