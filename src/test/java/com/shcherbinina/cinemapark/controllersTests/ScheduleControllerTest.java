package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.restControllers.ScheduleController;
import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleControllerTest {
    @Mock
    private AdminMovieSessionService adminMovieSessionService;

    @InjectMocks
    ScheduleController scheduleController;

    private List<AdminSessionDTO> sessionDTOSExpected;

    @Before
    public void setUp() {
        sessionDTOSExpected = new ArrayList<>();

        AdminSessionDTO dto1 = new AdminSessionDTO();
        dto1.setId(1);
        dto1.setCost(25.00);
        dto1.setMovieName("07-12-2020");
        dto1.setWishDate("2020-11-14T14:05:00");
        dto1.setHallName("Relax");
        dto1.setTime("21:15:00");
        dto1.setMovieName("Interstellar");

        AdminSessionDTO dto2 = new AdminSessionDTO();
        dto2.setId(2);
        dto2.setCost(25.00);
        dto2.setMovieName("07-17-2020");
        dto2.setWishDate("2020-08-14T14:05:00");
        dto2.setHallName("3D");
        dto2.setTime("21:20:00");
        dto1.setMovieName("Inception");
    }

    @Test
    public void getScheduleTest_validHallId_happy() {
        Mockito.when(adminMovieSessionService.getAllMovieSessionsByDate("2020-06-29")).thenReturn(sessionDTOSExpected);

        List<AdminSessionDTO> actual = scheduleController.getSchedule("2020-06-29");

        Mockito.verify(adminMovieSessionService).getAllMovieSessionsByDate("2020-06-29");

        Assert.assertEquals(sessionDTOSExpected, actual);
    }
}
