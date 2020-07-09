package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.restControllers.ScheduleController;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleControllerTest {
    @Mock
    private MovieSessionService movieSessionService;

    @InjectMocks
    ScheduleController scheduleController;

    private List<MovieSessionDTO> sessionDTOSExpected;

    @Before
    public void setUp() {
        sessionDTOSExpected = new ArrayList<>();

        MovieSessionDTO dto1 = new MovieSessionDTO();
        dto1.setId(1);
        dto1.setCost(25.00);
        dto1.setDate(new Date());
        dto1.setCinemaHallId(1);
        dto1.setTime(new Time(1));
        dto1.setMovie(new MovieDTO());

        MovieSessionDTO dto2 = new MovieSessionDTO();
        dto2.setId(2);
        dto2.setCost(25.00);
        dto2.setDate(new Date());
        dto2.setCinemaHallId(2);
        dto2.setTime(new Time(1));
        dto1.setMovie(new MovieDTO());
    }

    @Test
    public void getScheduleTest_validHallId_happy() {
        Mockito.when(movieSessionService.getAllMovieSessionsByDate("2020-06-29")).thenReturn(sessionDTOSExpected);

        List<MovieSessionDTO> actual = scheduleController.getSchedule("2020-06-29");

        Mockito.verify(movieSessionService).getAllMovieSessionsByDate("2020-06-29");

        Assert.assertEquals(sessionDTOSExpected, actual);
    }
}
