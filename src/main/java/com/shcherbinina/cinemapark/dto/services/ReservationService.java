package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.CinemaHallDao;
import com.shcherbinina.cinemapark.dao.MovieSessionDao;
import com.shcherbinina.cinemapark.dao.ReservationDao;
import com.shcherbinina.cinemapark.dao.RowDao;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.BookedDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private MovieSessionDao movieSessionRepository;
    @Autowired
    private CinemaHallDao cinemaHallRepository;
    @Autowired
    private ReservationDao reservationRepository;
    @Autowired
    private RowDao rowRepository;
    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public List<RowDTO> getHallLayout(int sessionId) {
        MovieSession session = movieSessionRepository.getMovieSessionById(sessionId);
        if(session == null) return null;

        String hallRows = cinemaHallRepository.getHallRows(session.getCinemaHall().getId());
        List<Integer> rows = Utility.getIntArrayFromString(hallRows);

        Map<Integer, List<Integer>> reservedPlaces = getReservedPlacesForEachRow(sessionId);
        Map<Integer, Integer> placesAmount = getPlaceAmountForRow(rows);
        ArrayList<RowDTO> rowDTOS = new ArrayList<>();

        for(int i = 0; i < rows.size(); i++) {
            int id = i + 1;
            int placesAmountForRow = placesAmount.get(rows.get(i));

            List<Integer> allPlaces = getAllPlaces(placesAmountForRow);
            List<Integer> reservedPlacesForRow = reservedPlaces.get(id);
            if(reservedPlacesForRow == null) reservedPlacesForRow = new ArrayList<>();
            List<Integer> freePlaces = Utility.getDifferenceList(allPlaces, reservedPlacesForRow);

            RowDTO rowDTO = new RowDTO(id, placesAmountForRow, reservedPlacesForRow, freePlaces);
            rowDTOS.add(rowDTO);
        }

        return rowDTOS;
    }

    private Map<Integer, List<Integer>> getReservedPlacesForEachRow(int sessionId) {
        List<Reservation> reservations = reservationRepository.getReservationsBySessionId(sessionId);

        HashMap<Integer, List<Integer>> reservedPlaces = new HashMap<>();
        for(Reservation val: reservations) {
            List<Integer> places = reservedPlaces.get(val.getRowId());
            if(places == null) {
                places = new ArrayList<>();
            }
            places.add(val.getPlace());
            reservedPlaces.put(val.getRowId(), places);
        }
        return reservedPlaces;
    }

    @Override
    public void addNewReservation(ReservationDTO dto) {
        reservationRepository.addReservation(dtoConverter.convertToReservation(dto));
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteReservation(id);
    }

    @Override
    public void updateReservation(ReservationDTO dto) {
        reservationRepository.updateReservation(dtoConverter.convertToReservation(dto));
    }

    @Override
    public ReservationDTO getReservationById(int id) {
        return dtoConverter.convertToReservationDTO(reservationRepository.getReservationById(id));
    }

    @Override
    public List<ReservationDTO> getAllByUserId(int id) {
        List<Reservation> reservations = reservationRepository.getAllByUserId(id);
        return reservations.stream().map(res -> dtoConverter.convertToReservationDTO(res)).collect(Collectors.toList());
    }

    @Override
    public BookedDTO getBookedPlace(ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.getReservation(reservationDTO);
        MovieSession session = reservation.getMovieSession();

        BookedDTO booked = new BookedDTO();
        booked.setReservationId(reservation.getId());
        booked.setRowId(reservation.getRowId());
        booked.setPlace(reservation.getPlace());
        booked.setMovieName(session.getMovie().getName());
        booked.setHallName(session.getCinemaHall().getHallName());
        booked.setDate(session.getDate());
        booked.setTime(session.getTime());
        booked.setStatus(reservation.isPaid());

        return booked;
    }

    public Map<Integer, Integer> getPlaceAmountForRow(List<Integer> rowTypesIds) {
        List<RowCinemaHall> rows = rowRepository.getRowsByTypeIds(rowTypesIds);
        HashMap<Integer, Integer> placeAmount = new HashMap<>();
        for(RowCinemaHall val: rows) {
            placeAmount.put(val.getId(), val.getSeatsAmount());
        }
        return placeAmount;
    }

    private List<Integer> getAllPlaces(int placesAmount) {
        List<Integer> places = new ArrayList<>();
        for(int i = 0; i < placesAmount; i++) {
            places.add(i + 1);
        }
        return places;
    }
}
