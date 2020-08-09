package com.shcherbinina.cinemapark.controllersTests;

import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.restControllers.MovieController;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    MovieController movieController;

    private MovieDTO movieExpected;
    private List<MovieThumbnailDTO> moviesDTOExpected;

    @Before
    public void setUp() {
        movieExpected = new MovieDTO();
        movieExpected.setId(1);
        movieExpected.setName("Before we go");
        movieExpected.setActors("Chris Evans, Alice Eve");
        movieExpected.setDuration("95");
        movieExpected.setDescription("Chris Evans and Alice Eve star as two strangers whose chance encounter in Grand Central Terminal sparks a nighttime adventure through New York City that will change their lives forever.");
        movieExpected.setRating("6.5");
        movieExpected.setGenre("drama");
        movieExpected.setProducer("Chris Evans");
        movieExpected.setProductionYear("2015");
        movieExpected.setPremiereDate("2020-02-12");

        moviesDTOExpected = new ArrayList<>();
        MovieThumbnailDTO dto1 = new MovieThumbnailDTO();
        dto1.setId(1);
        dto1.setName("Before we go");
        dto1.setDuration("95");
        dto1.setDescription("Chris Evans and Alice Eve star as two strangers whose chance encounter in Grand Central Terminal sparks a nighttime adventure through New York City that will change their lives forever.");
        dto1.setRating(6.5);
        dto1.setGenre("drama");

        MovieThumbnailDTO dto2 = new MovieThumbnailDTO();
        dto1.setId(2);
        dto1.setName("Grace of Monaco");
        dto1.setDuration("102");
        dto1.setDescription("Academy Award®-winner Nicole Kidman captures the beauty and elegance of Grace Kelly in this true story of her transition from Hollywood starlet to Princess of Monaco. During a political dispute between Monaco's Prince Rainier III (Academy Award®-nominee Tim Roth) and France's Charles De Gaulle, Kelly's identity and marriage hang in the balance.");
        dto1.setRating(6.5);
        dto1.setGenre("drama");

        moviesDTOExpected.add(dto1);
        moviesDTOExpected.add(dto2);
    }

    @Test
    public void getMovieTest_happy() {
        Mockito.when(movieService.getMovieBySecondaryKey("before-we-go")).thenReturn(movieExpected);

        MovieDTO actual = movieController.getMovie("before-we-go");

        Mockito.verify(movieService).getMovieBySecondaryKey("before-we-go");

        Assert.assertEquals(movieExpected, actual);
    }

    @Test
    public void getMoviesTest_happy() {
        Mockito.when(movieService.getMoviesNowInCinema()).thenReturn(moviesDTOExpected);

        List<MovieThumbnailDTO> actual = movieController.getMovies();

        Mockito.verify(movieService).getMoviesNowInCinema();

        Assert.assertEquals(moviesDTOExpected, actual);
    }

    @Test
    public void getMoviesSoonTest_happy() {
        Mockito.when(movieService.getMoviesSoonInCinema()).thenReturn(moviesDTOExpected);

        List<MovieThumbnailDTO> actual = movieController.getMoviesSoon();

        Mockito.verify(movieService).getMoviesSoonInCinema();

        Assert.assertEquals(moviesDTOExpected, actual);
    }
}
