package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.controllers.MainController;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.IMovieService;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MainController mainController;

    private List<MovieDTO> moviesDTOExpected;

    @Before
    public void setUp() {
        moviesDTOExpected = new ArrayList<>();
        MovieDTO dto1 = new MovieDTO();
        dto1.setId(1);
        dto1.setName("Before we go");
        dto1.setImageUrl("bbbb");
        dto1.setActors("Chris Evans, Alice Eve");
        dto1.setDuration(95);
        dto1.setDescription("Chris Evans and Alice Eve star as two strangers whose chance encounter in Grand Central Terminal sparks a nighttime adventure through New York City that will change their lives forever.");
        dto1.setRating(6.5);
        dto1.setGenre("drama");
        dto1.setProducer("Chris Evans");
        dto1.setProductionYear("2015");
        dto1.setPremiereDate(new Date(1));

        MovieDTO dto2 = new MovieDTO();
        dto1.setId(2);
        dto1.setName("Grace of Monaco");
        dto1.setImageUrl("vvvv");
        dto1.setActors("Nicole Kidman, Tim Roth");
        dto1.setDuration(102);
        dto1.setDescription("Academy Award®-winner Nicole Kidman captures the beauty and elegance of Grace Kelly in this true story of her transition from Hollywood starlet to Princess of Monaco. During a political dispute between Monaco's Prince Rainier III (Academy Award®-nominee Tim Roth) and France's Charles De Gaulle, Kelly's identity and marriage hang in the balance.");
        dto1.setRating(6.5);
        dto1.setGenre("drama");
        dto1.setProducer("Pierre-Ange Le Pogam, Uday Chopra");
        dto1.setProductionYear("2014");
        dto1.setPremiereDate(new Date(2));

        moviesDTOExpected.add(dto1);
        moviesDTOExpected.add(dto2);
    }

    @Test
    public void getMoviesTest_happy() {
        Mockito.when(movieService.getMoviesNowInCinema()).thenReturn(moviesDTOExpected);

        List<MovieDTO> actual = mainController.getMovies();

        Mockito.verify(movieService).getMoviesNowInCinema();

        Assert.assertEquals(moviesDTOExpected, actual);
    }
}
