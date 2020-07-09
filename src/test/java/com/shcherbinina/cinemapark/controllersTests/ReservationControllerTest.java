package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.restControllers.ReservationController;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {
    @Mock
    private ReservationService reservationService;

    @InjectMocks
    ReservationController reservationController;

    private List<RowDTO> rowsDTOExpected;
    private ReservationDTO reservationDTO;

    @Before
    public void setUp() {
        rowsDTOExpected = new ArrayList<>();

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

        rowsDTOExpected.add(rowDTO1);
        rowsDTOExpected.add(rowDTO2);

        reservationDTO = new ReservationDTO();
        reservationDTO.setId(1);
        reservationDTO.setRowId(2);
        reservationDTO.setPlace(1);
        reservationDTO.setSessionId(1);
        reservationDTO.setUserId(1);
    }

    @Test
    public void getHallPlanTest_validHallId_happy() {
        Mockito.when(reservationService.getHallLayout(1)).thenReturn(rowsDTOExpected);

        List<RowDTO> actual = reservationController.getHallPlan("1");

        Mockito.verify(reservationService).getHallLayout(1);

        Assert.assertEquals(rowsDTOExpected, actual);
    }

    @Test
    public void getHallPlanTest_invalidHallId_unhappy() {
        Mockito.when(reservationService.getHallLayout(1)).thenReturn(null);

        List<RowDTO> actual = reservationController.getHallPlan("1");

        Mockito.verify(reservationService).getHallLayout(1);

        Assert.assertNull(actual);
    }

}
