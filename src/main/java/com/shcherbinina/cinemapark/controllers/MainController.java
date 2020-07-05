package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemapark")
public class MainController {

    @Autowired
    private IMovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MovieDTO> getMovies() {
        List<MovieDTO> movies = movieService.getMoviesNowInCinema();
        return movies;
    }
}