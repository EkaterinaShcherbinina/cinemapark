package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie-service")
public class MovieController {

    @Autowired
    private MovieService movieService;

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
    public ResponseEntity<Object> postMovie(@RequestBody @Valid MovieDTO movieDTO, BindingResult result) throws PayloadValidationException {
        if(result.hasErrors()) throw new PayloadValidationException(Constants.payloadInvalidDataMessage);

        movieService.addNewMovie(movieDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        movieService.deleteMovie(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateMovie(@RequestBody @Valid MovieDTO movieDTO, BindingResult result) throws PayloadValidationException {
        if(result.hasErrors()) throw new PayloadValidationException(Constants.payloadInvalidDataMessage);

        movieService.updateMovie(movieDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
