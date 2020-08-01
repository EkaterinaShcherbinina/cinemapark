package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;

import java.util.List;

public interface IAdminMovieSessionService {
    void updateMovieSession(AdminSessionDTO sessionDTO);
    void addMovieSession(AdminSessionDTO sessionDTO);
    AdminSessionDTO getById(int sessionId);
    List<AdminSessionDTO> getAllMovieSessionsByDate(String date);
    List<AdminSessionDTO> getSessionsByDateAndMovieName(String date, int movieId);
}
