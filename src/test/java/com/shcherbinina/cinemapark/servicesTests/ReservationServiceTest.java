package com.shcherbinina.cinemapark.servicesTests;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.ReservationRepository;
import com.shcherbinina.cinemapark.dao.repository.RowRepository;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

public class ReservationServiceTest {
    @Mock
    private MovieSessionRepository movieSessionRepository;
    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private CinemaHallRepository cinemaHallRepository;
    @Mock
    private RowRepository rowRepository;

    @InjectMocks
    private ReservationService reservationService;

    private List<Reservation> reservations;
    private MovieSession movieSession;
    private String hallRows = "1,3";
    private List<RowCinemaHall> rows;
    private List<RowDTO> rowDTOSExpected;
    private List<Reservation> reservationsForAllPlaces;
    private List<RowDTO> allPlacesReservedRowDTOSExpected;
    private List<RowDTO> allPlacesFreeRowDTOSExpected;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setRowId(2);
        reservation.setPlace(1);
        reservation.setUser(new User());
        reservation.setMovieSession(new MovieSession());

        reservations = new ArrayList<>();
        reservations.add(reservation);
        for(int i = 2; i < 4; i++) {
            Reservation res = new Reservation();
            res.setId(i);
            res.setRowId(1);
            res.setPlace(i);
            res.setUser(new User());
            res.setMovieSession(new MovieSession());
            reservations.add(res);
        }

        movieSession = new MovieSession();
        movieSession.setMovie(new Movie());
        movieSession.setCinemaHall(new CinemaHall());

        rows = new ArrayList<>();
        RowCinemaHall row1 = new RowCinemaHall(1, 7);
        RowCinemaHall row2 = new RowCinemaHall(3, 10);
        rows.add(row1);
        rows.add(row2);

        rowDTOSExpected = new ArrayList<>();

        List<Integer> reservedPlaces1;
        Integer[] reservedArray = {2,3};
        reservedPlaces1 = Arrays.asList(reservedArray);
        List<Integer> freePlaces1;
        Integer[] free1 = {1,4,5,6,7};
        freePlaces1 = Arrays.asList(free1);
        RowDTO rowDTO1 = new RowDTO(1, 7, reservedPlaces1, freePlaces1);

        List<Integer> reservedPlaces2;
        Integer[] reservedArray2 = {1};
        reservedPlaces2 = Arrays.asList(reservedArray2);
        List<Integer> freePlaces2;
        Integer[] free2 = {2,3,4,5,6,7,8,9,10};
        freePlaces2 = Arrays.asList(free2);
        RowDTO rowDTO2 = new RowDTO(2, 10, reservedPlaces2, freePlaces2);

        rowDTOSExpected.add(rowDTO1);
        rowDTOSExpected.add(rowDTO2);

        reservationsForAllPlaces = new ArrayList<>();
        int j = 1;
        for(int i = 1; i <= 7; i++) {
            Reservation res = new Reservation();
            res.setId(j++);
            res.setRowId(1);
            res.setPlace(i);
            res.setUser(new User());
            res.setMovieSession(new MovieSession());
            reservationsForAllPlaces.add(res);
        }
        for(int i = 1; i <= 10; i++) {
            Reservation res = new Reservation();
            res.setId(j++);
            res.setRowId(2);
            res.setPlace(i);
            res.setUser(new User());
            res.setMovieSession(new MovieSession());
            reservationsForAllPlaces.add(res);
        }

        allPlacesReservedRowDTOSExpected = new ArrayList<>();
        List<Integer> allReservedPlaces1;
        Integer[] reserved1 = {1,2,3,4,5,6,7};
        allReservedPlaces1 = Arrays.asList(reserved1);
        List<Integer>noFreePlaces1 = new ArrayList<>();
        RowDTO allReservedPlacesRowDTO1 = new RowDTO(1, 7, allReservedPlaces1, noFreePlaces1);

        Integer[] reserved2 = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> allReservedPlaces2 = Arrays.asList(reserved2);
        List<Integer> noFreePlaces2 = new ArrayList<>();
        RowDTO allReservedPlacesRowDTO2 = new RowDTO(2, 10, allReservedPlaces2, noFreePlaces2);

        allPlacesReservedRowDTOSExpected.add(allReservedPlacesRowDTO1);
        allPlacesReservedRowDTOSExpected.add(allReservedPlacesRowDTO2);

        allPlacesFreeRowDTOSExpected = new ArrayList<>();
        List<Integer> noReservedPlaces1 = new ArrayList<>();
        Integer[] allFree1 = {1,2,3,4,5,6,7};
        List<Integer> allFreePlaces1 = Arrays.asList(allFree1);
        RowDTO allFreePlacesRowDTO1 = new RowDTO(1, 7, noReservedPlaces1, allFreePlaces1);

        List<Integer> noReservedPlaces2 = new ArrayList<>();
        Integer[] allFree2 = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> allFreePlaces2 = Arrays.asList(allFree2);
        RowDTO allFreePlacesRowDTO2 = new RowDTO(2, 10, noReservedPlaces2, allFreePlaces2);

        allPlacesFreeRowDTOSExpected.add(allFreePlacesRowDTO1);
        allPlacesFreeRowDTOSExpected.add(allFreePlacesRowDTO2);
    }

    @Test
    public void getHallLayoutTest_validSessionId_happy() {
        Mockito.when(movieSessionRepository.getMovieSessionById(1)).thenReturn(movieSession);
        Mockito.when(cinemaHallRepository.getHallRows(2)).thenReturn(hallRows);
        Mockito.when(reservationRepository.getReservationsBySessionId(1))
                .thenReturn(reservations);
        Mockito.when(rowRepository.getRowsByTypeIds(Mockito.any())).thenReturn(rows);

        List<RowDTO> actual = reservationService.getHallLayout(1);

        Mockito.verify(movieSessionRepository).getMovieSessionById(Mockito.eq(1));
        Mockito.verify(cinemaHallRepository).getHallRows(Mockito.eq(2));
        Mockito.verify(reservationRepository).getReservationsBySessionId(Mockito.eq(1));
        Mockito.verify(rowRepository).getRowsByTypeIds(Mockito.any());

        Assert.assertEquals(rowDTOSExpected, actual);
    }

    @Test
    public void getHallLayoutTest_invalidSessionId_unhappy() {
        Mockito.when(movieSessionRepository.getMovieSessionById(Mockito.anyInt())).thenReturn(null);

        List<RowDTO> actual = reservationService.getHallLayout(Mockito.anyInt());

        Mockito.verify(movieSessionRepository).getMovieSessionById(Mockito.anyInt());
        Mockito.verifyNoInteractions(cinemaHallRepository);

        Assert.assertNull(actual);
    }

    @Test
    public void getHallLayoutTest_withAllReservedPlaces_happy() {
        Mockito.when(movieSessionRepository.getMovieSessionById(1)).thenReturn(movieSession);
        Mockito.when(cinemaHallRepository.getHallRows(2)).thenReturn(hallRows);
        Mockito.when(reservationRepository.getReservationsBySessionId(1))
                .thenReturn(reservationsForAllPlaces);
        Mockito.when(rowRepository.getRowsByTypeIds(Mockito.any())).thenReturn(rows);

        List<RowDTO> actual = reservationService.getHallLayout(1);

        Mockito.verify(movieSessionRepository).getMovieSessionById(Mockito.eq(1));
        Mockito.verify(cinemaHallRepository).getHallRows(Mockito.eq(2));
        Mockito.verify(reservationRepository).getReservationsBySessionId(Mockito.eq(1));
        Mockito.verify(rowRepository).getRowsByTypeIds(Mockito.any());

        Assert.assertEquals(allPlacesReservedRowDTOSExpected, actual);
    }

    @Test
    public void getHallLayoutTest_withAllFreePlaces_happy() {
        Mockito.when(movieSessionRepository.getMovieSessionById(1)).thenReturn(movieSession);
        Mockito.when(cinemaHallRepository.getHallRows(2)).thenReturn(hallRows);
        Mockito.when(reservationRepository.getReservationsBySessionId(1))
                .thenReturn(new ArrayList<>());
        Mockito.when(rowRepository.getRowsByTypeIds(Mockito.any())).thenReturn(rows);

        List<RowDTO> actual = reservationService.getHallLayout(1);

        Mockito.verify(movieSessionRepository).getMovieSessionById(Mockito.eq(1));
        Mockito.verify(cinemaHallRepository).getHallRows(Mockito.eq(2));
        Mockito.verify(reservationRepository).getReservationsBySessionId(Mockito.eq(1));
        Mockito.verify(rowRepository).getRowsByTypeIds(Mockito.any());

        Assert.assertEquals(allPlacesFreeRowDTOSExpected, actual);
    }
    }
