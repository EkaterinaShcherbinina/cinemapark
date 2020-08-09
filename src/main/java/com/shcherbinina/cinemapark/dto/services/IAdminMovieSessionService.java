package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;

import java.util.List;

public interface IAdminMovieSessionService {
    void updateMovieSession(AdminSessionDTO sessionDTO);
    void addMovieSession(AdminSessionDTO sessionDTO) throws BusinessValidationException;
    AdminSessionDTO getById(int sessionId);
    List<AdminSessionDTO> getAllMovieSessionsByDate(String date);
    List<AdminSessionDTO> getSessionsByDateAndMovieName(String date, int movieId);
}
