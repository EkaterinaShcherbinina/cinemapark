package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.ValidationHelper;
import com.shcherbinina.cinemapark.validation.payloadValidation.MovieDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-service")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieDTOValidator movieValidator;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MovieDTO getMovie(@PathVariable String id) {
        return movieService.getMovieBySecondaryKey(id);
    }

    @RequestMapping(value="/get-all-now", method = RequestMethod.GET)
    public List<MovieThumbnailDTO> getMovies() {
        List<MovieThumbnailDTO> movies = movieService.getMoviesNowInCinema();
        return movies;
    }

    @RequestMapping(value="/get-all-soon", method = RequestMethod.GET)
    public List<MovieThumbnailDTO> getMoviesSoon() {
        List<MovieThumbnailDTO> movies = movieService.getMoviesSoonInCinema();
        return movies;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovie(@RequestBody @Validated(MovieDTO.New.class) MovieDTO movieDTO,
                                            BindingResult bindingResult) throws PayloadValidationException {
        ValidationHelper.checkErrors(bindingResult);
        movieService.addNewMovie(movieDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> updateMovie(@RequestBody @Validated(MovieDTO.Update.class) MovieDTO movieDTO,
                                              BindingResult bindingResult) throws PayloadValidationException {
        ValidationHelper.checkErrors(bindingResult);
        movieService.updateMovie(movieDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
