package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.UserHistoryDTO;

public interface IAccountService {
    UserHistoryDTO getUserHistory(int userId);
}
