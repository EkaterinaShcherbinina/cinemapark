package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.controllers.SoonInCinemaController;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
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
public class SoonInCinemaControllerTest {
    @InjectMocks
    private SoonInCinemaController soonInCinemaController;

    @Mock
    private MovieService movieService;

    private MovieDTO movieExpected;
    private List<MovieDTO> moviesExpected;

    @Before
    public void setUp() {
        movieExpected = new MovieDTO();
        movieExpected.setId(1);
        movieExpected.setName("Before we go");
        movieExpected.setImageUrl("bbbb");
        movieExpected.setActors("Chris Evans, Alice Eve");
        movieExpected.setDuration(95);
        movieExpected.setDescription("Chris Evans and Alice Eve star as two strangers whose chance encounter in Grand Central Terminal sparks a nighttime adventure through New York City that will change their lives forever.");
        movieExpected.setRating(6.5);
        movieExpected.setGenre("drama");
        movieExpected.setProducer("Chris Evans");
        movieExpected.setProductionYear("2015");
        movieExpected.setPremiereDate(new Date(1));

        moviesExpected = new ArrayList<>();
        moviesExpected.add(movieExpected);
    }

    @Test
    public void getMoviesSoonTest_happy() {
        Mockito.when(movieService.getMoviesSoonInCinema()).thenReturn(moviesExpected);

        List<MovieDTO> actual = soonInCinemaController.getMoviesSoon();

        Mockito.verify(movieService).getMoviesSoonInCinema();

        Assert.assertEquals(moviesExpected, actual);
    }
}
