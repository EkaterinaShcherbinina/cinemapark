package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;

import java.util.List;
import java.util.Map;

public interface IReservationRepository {
    List<Reservation> getReservationsBySessionId(int sessionId);
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(int reservationId);
    Reservation getReservationById(int reservationId);
    Reservation getReservation(ReservationDTO dto);
    List<Reservation> getAllByUserId(int userId);
}
