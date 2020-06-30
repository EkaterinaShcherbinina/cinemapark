package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovie(@RequestBody MovieDTO movieDTO)
    {
        movieService.addNewMovie(movieDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        movieService.deleteMovie(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody MovieDTO movieDTO) {
        movieService.updateMovie(movieDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
