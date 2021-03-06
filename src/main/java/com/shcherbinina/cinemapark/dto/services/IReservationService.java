package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.BookedDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;

import java.util.List;

public interface IReservationService {
    List<RowDTO> getHallLayout(int sessionId);
    void addNewReservation(ReservationDTO dto);
    void deleteReservation(int id);
    void updateReservation(ReservationDTO dto);
    ReservationDTO getReservationById(int id);
    List<ReservationDTO> getAllByUserId(int id);
    BookedDTO getBookedPlace(ReservationDTO reservationDTO);
}
