package com.shcherbinina.cinemapark.servicesTests;

import com.shcherbinina.cinemapark.dao.ReservationDAO;
import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dao.entity.User;
import com.shcherbinina.cinemapark.dao.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Date;

public class ReservationRepositoryTest {
    @Mock
    private ReservationDAO reservationDAO;

    @InjectMocks
    private ReservationRepository reservationRepository;

    private Reservation reservation;
    private Reservation reservationExpected;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        reservation = new Reservation();
        reservation.setId(1);
        reservation.setRowId(8);
        reservation.setPlace(1);
        reservation.setUser(new User(1, "first", "last", "password",
                "aaa.com", 0.00));
        reservation.setMovieSession(new MovieSession(1, 1, new Date(1), new Time(0),
                100.0, new CinemaHall(1, 3, "1")));

        reservationExpected = new Reservation();
        reservationExpected.setId(1);
        reservationExpected.setRowId(8);
        reservationExpected.setPlace(1);
        reservationExpected.setUser(new User(1, "first", "last", "password",
                "aaa.com", 0.00));
        reservationExpected.setMovieSession(new MovieSession(1, 1, new Date(1), new Time(0),
                100.0, new CinemaHall(1, 3, "1")));
    }

    @Test
    public void getReservationById_validId_happy() {
        Mockito.when(reservationDAO.findById(1))
                .thenReturn(reservation);

        Reservation actual = reservationRepository.getReservationById(1);

        Mockito.verify(reservationDAO).findById(Mockito.eq(1));

        Assert.assertEquals(actual, reservationExpected);
    }

    @Test
    public void getReservationById_invalidId_unhappy() {
        Mockito.when(reservationDAO.findById(Mockito.anyInt()))
                .thenReturn(null);

        Reservation actual = reservationRepository.getReservationById(Mockito.anyInt());

        Mockito.verify(reservationDAO).findById(Mockito.anyInt());

        Assert.assertNull(actual);
    }
}
