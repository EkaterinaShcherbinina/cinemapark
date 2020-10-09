package com.shcherbinina.cinemapark.servicesTests;

import com.shcherbinina.cinemapark.dao.repository.ReservationRepository;
import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.ReservationDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class ReservationRepositoryTest {
    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationDao reservationDao;

    private Reservation reservation;
    private Reservation reservationExpected;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Movie movie = new Movie();
        movie.setId(1);

        reservation = new Reservation();
        reservation.setId(1);
        reservation.setRowId(8);
        reservation.setPlace(1);
        reservation.setUser(new User(1, "first", "last", "password",
                "aaa.com", new BigDecimal(0.00)));
        reservation.setMovieSession(new MovieSession(1, new Date(1), new Time(0),
                100.0, new CinemaHall(1, 3, "1"), movie));

        reservationExpected = new Reservation();
        reservationExpected.setId(1);
        reservationExpected.setRowId(8);
        reservationExpected.setPlace(1);
        reservationExpected.setUser(new User(1, "first", "last", "password",
                "aaa.com", new BigDecimal(0.00)));
        reservationExpected.setMovieSession(new MovieSession( 1, new Date(1), new Time(0),
                100.0, new CinemaHall(1, 3, "1"), movie));
    }

    @Test
    public void getReservationById_validId_happy() {
        Mockito.when(reservationRepository.findById(1))
                .thenReturn(reservation);

        Reservation actual = reservationDao.getReservationById(1);

        Mockito.verify(reservationRepository).findById(Mockito.eq(1));

        Assert.assertEquals(actual, reservationExpected);
    }

    @Test
    public void getReservationById_invalidId_unhappy() {
        Mockito.when(reservationRepository.findById(Mockito.anyInt()))
                .thenReturn(null);

        Reservation actual = reservationDao.getReservationById(Mockito.anyInt());

        Mockito.verify(reservationRepository).findById(Mockito.anyInt());

        Assert.assertNull(actual);
    }
}
