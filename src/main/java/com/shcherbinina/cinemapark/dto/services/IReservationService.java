package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;

import java.util.List;
import java.util.Map;

public interface IReservationService {
    List<RowDTO> getHallLayout(int sessionId);
    void addNewReservation(ReservationDTO dto);
    void deleteReservation(int id);
    void updateReservation(ReservationDTO dto);
}
