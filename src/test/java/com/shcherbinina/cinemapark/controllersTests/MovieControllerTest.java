package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.controllers.MovieController;
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

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    MovieController movieController;

    private MovieDTO movieExpected;

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
    }

    @Test
    public void getMoviesTest_happy() {
        Mockito.when(movieService.getMovieByKey("before-we-go")).thenReturn(movieExpected);

        MovieDTO actual = movieController.getMovie("before-we-go");

        Mockito.verify(movieService).getMovieByKey("before-we-go");

        Assert.assertEquals(movieExpected, actual);
    }
}
