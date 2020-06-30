package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MovieDTO getMovie(@PathVariable String id) {
        return movieService.getMovieByKey(id);
    }
}
